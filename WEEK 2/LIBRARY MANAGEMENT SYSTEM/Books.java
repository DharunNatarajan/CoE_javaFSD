class Books
{
	private String title;
	private String author;
	private String ISBN;
	
	Books(String title, String author, String ISBN)
	{
		super();
		this.title = title;
		this.author = author;
		this.ISBN = ISBN;
	}
	//getters and setters
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getTitle()
	{
		return title;
	}
	public void setAuthor(String author)
	{
		this.author = author;
	}
	public String getAuthor()
	{
		return author;
	}
	public void setISBN(String ISBN)
	{
		this.ISBN = ISBN;
	}
	public String getISBN()
	{
		return ISBN;
	}
	@Override
	public String toString()
	{
		return  "title : "+title+",author : "+author+",ISBN : "+ISBN;
	}
}
