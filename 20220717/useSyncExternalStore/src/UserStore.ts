import { Action, Store } from './core';

@Store()
export default class UserStore {
  name: string = '';

  @Action()
  changeName(name: string) {
    this.name = name;
  }
}
