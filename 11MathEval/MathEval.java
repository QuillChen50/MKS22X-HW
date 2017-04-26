public class ExpressionTree{
  /*instance variables, constructors, and some methods not shown*/
  
  /*accessor method for the value, precondition is that isValue() is true.*/
  private double getValue(){    /*implementation not shown*/ }
  /*accessor method for the operation, precondition is that isOp() is true.*/
  private char getOp(){    /*implementation not shown*/  }    
  /* accessor method for left, precondition is that isOp() is true.*/
  private ExpressionTree getLeft(){    /*implementation not shown*/  }
  /* accessor method for right, precondition is that isOp() is true.*/
  private ExpressionTree getRight(){    /*implementation not shown*/  }

  private boolean isOp(){    /*implementation not shown*/  }
  private boolean isValue(){    /*implementation not shown*/  }


  /* you write these four methods, hint: think recursively */

  /*return the expression as an infix notation string with parenthesis*/
  /* The sample tree at the top would be: "( 3 + (2 * 10))"     */
  public String toString(){    /*you are to write this method*/  }

  /*return the expression as a postfix notation string without parenthesis*/
  /* The sample tree would be: "3 2 10 * +"     */
  public String toStringPostfix(){    /*you are to write this method*/  }

  /*return the expression as a prefix notation string without parenthesis*/
  /* The sample tree would be: "+ 3 * 2 10"     */
  public String toStringPrefix(){    /*you are to write this method*/  }

  /*return the value of the expression tree*/
  public double evaluate(){    /*you are to write this method*/  }

}


public MathEval{

    public static double eval (String s){
String[] tokens = s.split(" ");
    Stack<Double> values = new Stack<Double>();
    
    for(String token : tokens){
      if(isOp(token)){
       	 values.push(perform(token,values.pop(),values.pop()));
      }
      else{
        values.push(Double.parseDouble(token));
      }
    }
    
    return values.pop();

    }

    public static boolean isOperator (Array a){

    }

    public static double apply (String operator, String a, String b){
	if (operator.equals("+")){

    }

	if (operator.equals("-")){

    }

	if (operator.equals("*")){

    }

	if (operator.equals("/")){

    }

	public static array breakdown (String a){

	}







				       }}
