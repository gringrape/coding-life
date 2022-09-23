/* eslint-disable no-eval */
export default function toBinarySting(expression) {
  const number = eval(expression);
  return Number(number).toString(2);
}
