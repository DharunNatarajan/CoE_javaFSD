class MaxBooksAllowedException extends Exception 
{
	private static final long serialVersionUID = 1L;
	public MaxBooksAllowedException(String msg)
	{
		super(msg);
	}
}