package Q13_01_Private_Constructor;

public class Question {
	private Question() {
		System.out.println("Q");
	}
	
    static class A {
        private A() {
        }
    }

    static class B extends A {
    	public B() {
    	}
    }
    
	public static void main(String[] args) {
		new B();
	}

}
