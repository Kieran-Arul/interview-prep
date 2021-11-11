// same as py
package main

import (
	"fmt"
)
func main() {
	n := 5
	if n == 1 {
		fmt.Println(1)
	}else {

	}
	dfs := [] int {1,2}
	for i := 2; i < n; i++{
		dfs = append(dfs,0)
		dfs[i] = dfs[i-1] + dfs[i-2]
	} 
	fmt.Println(dfs[n-1])
}