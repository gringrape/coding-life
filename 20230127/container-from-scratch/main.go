// 1. 이미지 실행
// docker         run image <cmd> <params>
// go run main.go run

package main

import (
	"fmt"
	"os"
)

func main() {
	switch os.Args[1] {
	case "run":
		run()
	default:
		panic("Invalid command")
	}
}

func run() {
	fmt.Printf("Running %v\n", os.Args[2:])
}
