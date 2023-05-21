import java.util.List;

public class MovieDetail {

	public String moviename;
	public Float movierating;
	public String releasedate;

	public MovieDetail() {
		// TODO Auto-generated constructor stub
	}

	public void FilterMoviesByRating(List<MovieDetail> md, float rating) {
		List<MovieDetail>moviedetails=md;
		for(int i=0;i<moviedetails.size();i++)
		{
           if(md.get(i).movierating==rating)
           {
        	   System.out.println("The Movie with your selected Rating is");
        	   System.out.println(md.get(i).moviename.toString());
        	   System.out.println(md.get(i).releasedate.toString());
        	   System.out.println(md.get(i).movierating.toString());

           }
		}
	}
}
