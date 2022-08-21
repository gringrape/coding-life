store CounterStore {
  state count : Number = 0

  fun increase : Promise(Never, Void) {
    next { count = count + 1 }
  }

  fun decrease : Promise(Never, Void) {
    next { count = count - 1 }
  }
}
