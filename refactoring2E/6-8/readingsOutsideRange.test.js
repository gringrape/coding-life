import NumberRange from './NumberRange';

const context = describe;

function readingsOutsideRange(station, range) {
  return station.readings
    .filter((r) => r.temp < range.min || r.temp > range.max);
}

describe('readingsOutsideRange', () => {
  const station = {
    name: 'ZB1',
    readings: [
      { temp: 47, time: '2016-11-10 09:10' },
      { temp: 53, time: '2016-11-10 09:20' },
      { temp: 58, time: '2016-11-10 09:30' },
      { temp: 53, time: '2016-11-10 09:40' },
      { temp: 51, time: '2016-11-10 09:50' },
    ],
  };

  context('with operating plan', () => {
    const operatingPlan = {
      floorTemperature: 50,
      ceilTemperature: 55,
    };

    it('returns readings with out-of-range temperature', () => {
      const range = new NumberRange(operatingPlan.floorTemperature, operatingPlan.ceilTemperature);

      expect(readingsOutsideRange(station, range)).toHaveLength(2);
    });
  });
});
