export default class NumberRange {
  constructor(min, max) {
    this.data = { min, max };
  }

  get min() { return this.data.min; }

  get max() { return this.data.max; }

  contains(number) {
    return number >= this.min && number <= this.max;
  }
}
