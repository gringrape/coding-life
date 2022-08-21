suite "Main" {
  test "renders counter" {
    with Test.Html {
      <Main/>
      |> start()
      |> assertTextOf("h1", "Counter")
    }
  }
}
