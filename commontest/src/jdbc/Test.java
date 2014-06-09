package jdbc;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DatabaseOperate databaseOperate = new DatabaseOperate();
		databaseOperate.createTable("hello");
	}
}
