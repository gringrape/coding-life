fn main() {
  // 1. Fix issue - add positional argument
  println!("My name is {0}, {1} {0}", "Bond", "James");
  
  // 2. Fix issue - comment out  
  // println!("This struct `{}` won't print...", Structure(3));
  
  // 3. Print Pi, setup precision
  let pi = 3.141592;
  println!("Pi is roughly {pi:.3}");
  println!("Pi is roughly {pi:.N$}", N=3)
  println!("Pi is roughly {pi:.*}", 3);
}
