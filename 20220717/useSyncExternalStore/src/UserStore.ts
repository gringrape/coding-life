export default class UserStore {
  private listeners = new Set<Function>();

  private snapshot: any = {};

  subcribe(onChange: () => void): () => void {
    this.listeners.add(onChange);
    return () => this.listeners.delete(onChange);
  }

  getSnapshot(): any {
    return this.snapshot;
  }

  updateSnapshot({ key, value }: {
    key: string;
    value: string;
  }): any {
    this.snapshot = {
      ...this.snapshot,
      [key]: value,
    };

    this.listeners.forEach((listener) => listener(this.snapshot));
  }

  //
  name: string = '';

  changeName(name: string) {
    this.name = name;

    this.updateSnapshot({
      key: 'name',
      value: name,
    });
  }
}
