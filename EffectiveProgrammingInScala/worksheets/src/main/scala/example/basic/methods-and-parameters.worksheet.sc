def marathonDuration(speed: Double): Double = 
  val distance = 42.195
  val duration = distance / speed
  duration * 60

val aliceDuration = marathonDuration(speed = 12)
val bobDuration = marathonDuration(speed = 14)

// 연습한 것.
// - 타입 명시
// - named parameter
// - method 의 블락 지정하기 
