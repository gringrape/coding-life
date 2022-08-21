component Counter {
  style container {
    margin-inline: auto;
    padding-inline: 2em; 
    width: 600px;

    h1 {
      font-size: 2.5em;
    }

    button {
      font-size: 3em;
      width: 50%;
    }
  }
  
  style count {
    font-size: 3em;
    padding-inline: .5em;
    text-align: right;
    border: 1px solid black;
  }

  connect CounterStore exposing { 
    count,
    increase, 
    decrease,
  }

  fun render : Html {
    <div::container>
      <h1>"Counter"</h1>
      <div::count>
        <{ count |> Number.toString }>
      </div>
      <button onClick={increase}>
        "+"
      </button>
      <button onClick={decrease}>
        "-"
      </button>
    </div>
  }
}
