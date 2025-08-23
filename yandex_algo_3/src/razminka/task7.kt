package razminka

fun secondsToTime(seconds: Int): Triple<Int, Int, Int> {
    var secondsInDay = seconds
    if (seconds >= 86400) secondsInDay -= 86400

    val hours = secondsInDay / 3600
    secondsInDay -= hours * 3600
    val minutes = secondsInDay / 60
    val seconds = secondsInDay - (minutes * 60)

    return Triple(hours, minutes, seconds)
}

fun main() {
    val (hourSendRequest, minuteSendRequest, secondSendRequest) =
        readLine()!!.split(":").map { it.toInt() } // Client time
    val (hourGetRequestServer, minuteGetRequestServer, secondGetRequestServer) =
        readLine()!!.split(":").map { it.toInt() } // Server time
    val (hourGetRequestClient, minuteGetRequestClient, secondGetRequestClient) =
        readLine()!!.split(":").map { it.toInt() } // Client time

    val timeSendRequest = hourSendRequest * 3600 + minuteSendRequest * 60 + secondSendRequest
    val timeGetRequestServer = hourGetRequestServer * 3600 + minuteGetRequestServer * 60 + secondGetRequestServer
    var timeGetRequestClient = hourGetRequestClient * 3600 + minuteGetRequestClient * 60 + secondGetRequestClient

    if (timeGetRequestClient < timeSendRequest) timeGetRequestClient += 86400
    val delay = if((timeGetRequestClient - timeSendRequest) % 2 == 0) (timeGetRequestClient - timeSendRequest) / 2
        else (timeGetRequestClient - timeSendRequest) / 2 + 1

    val time = secondsToTime(timeGetRequestServer + delay)
    println("${if(time.first > 9) time.first else "0" + time.first.toString()}:" +
            "${if(time.second > 9) time.second else "0" + time.second.toString()}:" +
            "${if(time.third > 9) time.third else "0" + time.third.toString()}")
}