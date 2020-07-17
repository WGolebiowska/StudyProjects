function automatedTest(testArray) {

    console.log("================================");
    console.log("Starting a new test:");
    console.log(getStringExpression(testArray[0]) + "\n+\n" + getStringExpression(testArray[1]))
    console.log("Expected result:");
    var expectedResultExpression = getStringExpression(testArray[2]);
    console.log(expectedResultExpression);

    console.log("--------------------------------");
    console.log("Calling addExpressions function...");
    var t0 = performance.now();
    var result = addExpressions(testArray[0], testArray[1]);
    var t1 = performance.now();
    console.log("Call to addExpressions() took " + (t1 - t0) + " milliseconds.");

    console.log("--------------------------------");
    var resultExpression = getStringExpression(expressionArrayToExpression(result));
    console.log("Result:");
    console.log(resultExpression);

    if (resultExpression == expectedResultExpression)
        console.log("Success!");
    else
        console.log("Fail!");

}


