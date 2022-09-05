fn main() {
  // 1. Any arguments
  println!("{} days", 31);

  // 2. Positional argument
  println!("I like {0}, {1}", "apple", "banana");

  // 3. Named arguments
  println!("Hello, {name}!", name="Jonh");

  // 4. Format specifier
  println!("{number:*>5}", number=5);
  println!("{number:*>width$}", number=1, width=10);  

  // 5. Capture surrounding variable
  // - TODO: 타입에 대해서 체크해두기.
  let number: f64 = 1.0;
  let width: usize = 6;
  println!("{number:*>width$}");  
}
