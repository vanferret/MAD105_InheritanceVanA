
fun main() {

    fun callResident(){
        var seniorOut = false
        //gather the information
        println("Please enter customer name:")
        val customerName = readLine()!!
        println("Please enter Phone number:")
        val customerPhone = readLine()!!
        println("Please enter your address:")
        val customerAddress = readLine()!!
        println("Please enter the square footage:")
        val squareFootage = readLine()!!.toDouble()
        println("Are you a Senior Citizen? (Y/N):")
        val senior = readLine()!!
        if (senior == "Y") {seniorOut = true} else {seniorOut = false}

        val myResident = Residential(customerName,customerPhone,customerAddress,squareFootage,seniorOut)
        myResident.weeklycharge()
    }

    fun callCommercial(){
        var multiPropertyOut = false
        //gather the information
        println("Please enter customer name:")
        val customerName = readLine()!!
        println("Please enter Phone number:")
        val customerPhone = readLine()!!
        println("Please enter your address:")
        val customerAddress = readLine()!!
        println("Please enter the square footage:")
        val squareFootage = readLine()!!.toDouble()
        println("Please enter a name by which to reference address:")
        val propertyName = readLine()!!
        println("Do you have multiple properties that require service? (Y/N):")
        val multiProperty = readLine()!!
        if (multiProperty == "Y") {multiPropertyOut = true} else {multiPropertyOut = false}

        val myCommercial = Commercial(customerName,customerPhone,customerAddress,squareFootage,propertyName,multiPropertyOut)
        myCommercial.weeklycharge()
    }

    //Define our arrays of items and quantities
    val servicetypes = arrayOf("Residential","Commercial", "Done")

    // Then we get to offering up the option to guide the creation
    var writeout = ""
    var choice = -1

    fun listall() {
        for (i in 0..2) {
            println((i + 1).toString() + ". ${servicetypes[i]}")
        }
    }

    while(choice !in 0..servicetypes.size - 1){
        println("Please enter a number to receive a quote or exit.")
        listall()
        print("")
        choice = readLine()!!.toInt() - 1

        if (choice !in 0..servicetypes.size - 1)
            println("Invalid Entry, try again")
    }

    when (choice){
        0 -> callResident()
        1 -> callCommercial()
        !in 0..1 -> writeout = "Thank you for visiting. Goodbye!"
        else -> writeout = "We are experiencing a system error please try again later."
    }

    println(writeout)
}