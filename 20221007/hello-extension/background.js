class Time {
  constructor({ minute, second }) {
    this.minute = minute;
    this.second = second;
  }

  tick() {
    if (this.minute === 0 && this.second === 0) {
      return this;
    }

    if (this.second === 0) {
      return new Time({
        minute: this.minute - 1,
        second: 59,
      });
    }

    return new Time({
      minute: this.minute,
      second: this.second - 1,
    });
  }

  toString() {
    const minutePart = this.minute < 10 ? `0${this.minute}` : `${this.minute}`;
    const secondPart = this.second < 10 ? `0${this.second}` : `${this.second}`;

    return `${minutePart}:${secondPart}`;
  }
}

const state = {
  time: new Time({
    minute: 3,
    second: 0,
  }),

  setTime(time) {
    this.time = time;
  },
};

function showTime(time) {
  chrome.action.setBadgeText({
    text: time.toString(),
  });
}

chrome.runtime.onInstalled.addListener(() => {
  showTime(state.time.toString());

  setInterval(() => {
    const newTime = state.time.tick();
    state.setTime(
      newTime,
    );
    showTime(newTime.toString());
  }, 1000);
});
