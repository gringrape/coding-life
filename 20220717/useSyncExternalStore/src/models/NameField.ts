export default class NameField {
  value: string = '';

  error: string = '';

  constructor(value?: string, error?: string) {
    this.value = value || '';
    this.error = error || '';
  }

  update(value: string) {
    this.validate(value);
    return new NameField(value, this.error);
  }

  private validate(value: string) {
    if (value.length < 6) {
      this.error = '여섯글자 이상이어야 합니다';
    }
  }
}
