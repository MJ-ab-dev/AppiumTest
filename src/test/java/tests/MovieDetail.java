package tests;
import java.util.*;

public class MovieDetail {

	public String moviename;
	public Float movierating;
	public String releasedate;

	public MovieDetail() {
		// TODO Auto-generated constructor stub
	}

	public void FilterMoviesByRating(List<MovieDetail> md, float rating) {
		
		List<MovieDetail>moviedetails=md;
		boolean flag=false;
		for(int i=0;i<moviedetails.size();i++)
		{
           if(md.get(i).movierating==rating)
           {
        	   System.out.println("The Movie with your selected Rating is");
        	   System.out.println(md.get(i).moviename.toString());
        	   System.out.println(md.get(i).releasedate.toString());
        	   System.out.println(md.get(i).movierating.toString());
        	   flag=true;

           }
           if(!flag)
           {
        	   System.out.println("Hi, It seems like I have not selected any movie with which you wanted to test out this rating mechanism :)");
           }
		}
	}
	
	public void CompareMovieDetails(List<MovieDetail> md)
	{
		List<MovieDetail>moviedetails=md;
		if(moviedetails.get(0).moviename.equals("Avatar: The Way of Water" )&& moviedetails.get(0).releasedate.equals("Release Date : 2022-12-14") && moviedetails.get(0).movierating.toString().equals("8.0"))
		{
			System.out.println("Movie details of Avatar Match");
		}
		else
		{
			System.out.println("Movie details of Avatar do not Match");
		}
		if(moviedetails.get(1).moviename.equals("Fast X") && moviedetails.get(1).releasedate.equals("Release Date : 2023-05-17") && moviedetails.get(1).movierating.toString().equals("7.0"))
		{
			System.out.println("Movie details of Fast X Match");
		}
		else
		{
			System.out.println("Movie details of Fast X do not Match");
		}
		if(moviedetails.get(2).moviename.equals("Guardians of the Galaxy Vol. 3") && moviedetails.get(2).releasedate.equals("Release Date : 2023-05-03") && moviedetails.get(2).movierating.toString().equals("8.0"))
		{
			System.out.println("Movie details of Guardians of the Galaxy Vol. 3 Match");
		}
		else
		{
			System.out.println("Movie details of Guardians of the Galaxy Vol. 3 do not Match");
		}
		if(moviedetails.get(3).moviename.equals("The Super Mario Bros. Movie") && moviedetails.get(3).releasedate.equals("Release Date : 2023-04-05") && moviedetails.get(3).movierating.toString().equals("8.0"))
		{
			System.out.println("Movie details of The Super Mario Bros. Movie Match");
		}
		else
		{
			System.out.println("Movie details of The Super Mario Bros. Movie do not Match");
		}
	}
}
