package tasks1

fun main(){
    val deleteChar = "()-+"
    val nums = MutableList(4){readLine()!!.filterNot { it in deleteChar }}

    for (i in nums.indices){
        if (nums[i].length == 11) nums[i] = nums[i].substring(1)
        else nums[i] = "495" + nums[i]
    }

    for (i in 1..3){
        if(nums[0] == nums[i]) println("YES")
        else println("NO")
    }
}