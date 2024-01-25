-------------------------------
Lab 11 - Due 11/15, by 11:59 pm
-------------------------------

The purpose of the lab is to get everyone making progress on programming assignment 7.

[**Required:** You should also consider the following, which provides a little more detail.](./doing_lab_11.pdf)

**Note:** You can ignore the part about downloading the files from BrightSpace, they were already provided within your repository as start code.

## TODOs

1. Update `testCarData.java` to get the five commandline arguments that are passed to the program and assign them to the appropriate values

``` java
//TODO: get the command line arguments
String filename = "";               //arg0
double minTotalRange = 0.0;         //arg1
double maxTotalRange = 0.0;         //arg2
double minRemainingRange = 0.0;     //arg3
double maxRemainingRange = 0.0;     //arg4
```

2. Update `Car.java`

- Add the following fields:
	- `private final` id
	- `private final` fuel economy in miles per gallon
	- `private final` fuel capacity in gallons
	- `private` current fuel in gallons (needs to be a double and **not** final)
- Add a constructor that initializes the fields
- Add the get methods for the four fields (defined in `CarFunctions`)
	- **Note:** Eclipse can autogenerate getters and setters if you ask it to
- I've included an implementation of `toString()` that should work for both the lab and the programming assignment

3. Update `ManageCarData.java`
- Add three `private final` fields:
	- One `ArrayList` 
	- two `PriorityQueues` of type `CarFunctions`
- Add a no parameter constructor that instantiates the three fields
- Implement the `readData(String filename)` method
	- Open the input file as a `BufferedReader`. I used:
		- `java java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(filename))); ”`
	- Loop over the lines of the input file
		- Parse the id, fuel economy, fuel capacity, and current fuel
			- **Recall:** We have covered parsing text lines with `StringTokeizer`, `Scanner`, and `String.split()`
		- Create a new `Car` object with the above four values
		- Add the `Car` object to the `ArrayList` and two `PriorityQueues`
	- Implement `public ArrayList<CarFunctions> getCarList()`	
		- All you need to do is return a copy of the `ArrayList` of `CarFunctions` that you populated in `readData(String filename)`

## Getting credit

Demonstrate to a CA/TA the following:

`java testCarData sample_data2.txt 0 500 0 500`

The top of the output should be:

```
carList
1 20 40 25.0 800.0 500.0
2 24 40 20.0 960.0 480.0
3 20 30 28.0 600.0 560.0
4 24 30 12.0 720.0 288.0
5 20 30 6.0 600.0 120.0
```

Push the code so far to github and submit the latest commit hash on BrightSpace:

```
git add -A
git commit -m "finished lab 11, rest of program assignment 07 will come later."
git push origin
git rev-parse HEAD
```

## Continue on with Program Assignment 07

If you finish early, continue working on your implementation of `Car` and `ManagerCarData`.

[Back to Program Assignment 07.](/README.md)