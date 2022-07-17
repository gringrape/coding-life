/* eslint-disable max-classes-per-file */

export const STORE_PROPERTY_NAME = '_store';

export class ExternalStore {
  target: any;

  listeners = new Set<Function>();

  snapshot: any = {};

  propertyKeys: string[];

  constructor(target: any) {
    this.target = target;
    this.propertyKeys = Reflect.ownKeys(target).map(String);
  }

  subcribe(onChange: () => void): () => void {
    this.listeners.add(onChange);
    return () => this.listeners.delete(onChange);
  }

  getSnapshot(): any {
    return this.snapshot;
  }

  updateSnapshot(): any {
    this.snapshot = this.propertyKeys.reduce((acc, key) => ({
      ...acc,
      [key]: Reflect.get(this.target, key),
    }), {});

    this.listeners.forEach((listener) => listener(this.snapshot));
  }
}

// eslint-disable-next-line no-unused-vars
type Klass = { new (...args: any[]): {} };

export function Store() {
  return function decorator<T extends Klass>(klass: T) {
    return class extends klass {
      constructor(...args: any) {
        super(...args);
        const externalStore = new ExternalStore(this);
        Reflect.set(this, STORE_PROPERTY_NAME, externalStore);
        externalStore.updateSnapshot();
      }
    };
  };
}

export function Action() {
  return (target: any, propertyKey: string, descriptor: PropertyDescriptor) => {
    const method = descriptor.value;

    // eslint-disable-next-line no-param-reassign
    descriptor.value = function decorator(...args: any[]) {
      const returnValue = method.apply(this, args);
      Reflect.get(this, STORE_PROPERTY_NAME).updateSnapshot(); // 이것을 해주기 위함.
      return returnValue;
    };
  };
}
