package com.musicplayer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

	private static ArrayList<Album> albums = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Album album = new Album("album1", "AC/DC");
		album.addSong("TNT", 6.2);
		album.addSong("Highway to hell", 3.4);
		album.addSong("Thunder Struck", 2.3);
		albums.add(album);

		album = new Album("album2", "Eminum");
		album.addSong("Rap God", 3.4);
		album.addSong("Not Afraid", 4.2);
		album.addSong("Loose Yourself", 2.4);
		albums.add(album);

		LinkedList<Song> PlayList1 = new LinkedList<>();
		albums.get(0).addToPlaylist("TNT", PlayList1);
		albums.get(0).addToPlaylist("Highway to hell", PlayList1);
		albums.get(1).addToPlaylist("Rap God", PlayList1);
		albums.get(1).addToPlaylist("Not Afraid", PlayList1);

		play(PlayList1);

	}

	public static void play(LinkedList<Song> PlayList) {
          Scanner sc=new Scanner(System.in);
          boolean quite=false;
          boolean forward=true;
          
          ListIterator<Song> listIterator=PlayList.listIterator();
          if(PlayList.size()==0) {
        	  System.out.println("Playlist is empty");
          }else {
        	  System.out.println("Now playing "+listIterator.next().toString());
        	  printMenu();
          }
          while(!quite){
        	  int action=sc.nextInt();
        	  sc.nextLine();
        	  
        	  switch(action) {
        	      
        	  case 0:
        		  System.out.println("Playlist complete");
        		  quite=true;
        		  break;
        		  
        	  case 1:
        		  if(!forward) {
        			  if(listIterator.hasNext()) {
        				  listIterator.next();
        			  }
        			  forward=true;
        		  }
        		  if(listIterator.hasNext()) {
        			  System.out.println("Now Playing"+listIterator.next().toString());
        		  }else {
        			  System.out.println("No song Available , You have reached the end of list");
        			  forward=false;
        		  }
        		  break;
        	  case 2:
        		  if(forward) {
        			  if(listIterator.hasPrevious()) {
        				  listIterator.previous();        			  }
        		  }
        		  forward=false;
        		  if(listIterator.hasPrevious()) {
        			  System.out.println("Now playing "+listIterator.previous().toString());
        			  
        		  }else {
        			  System.out.println("We are at the first song....");
        			  forward=false;
        		  }
        		  break;
        		  
        	  case 3:
        		  if(forward) {
        			  if(listIterator.hasPrevious()) {
        				  System.out.println("Now playing "+listIterator.previous().toString());
        				  forward=false;
        			  }else {
        				  System.out.println("We are at the strat of the list");
        			  }
        		  }else {
        			  if(listIterator.hasNext()) {
        				  System.out.println("Now playing"+listIterator.next().toString());
        				  forward=true;
        			  }else {
        				  System.out.println("We have reached end of the list");
        			  }
        		  }
        		  break;
        		  
        	  case 4:
        		  printList(PlayList);
        		  break;
        	  case 5: 
        		  printMenu();
        		  break;
        	  case 6:
        		  if(PlayList.size()>0) {
        			  listIterator.remove();
        			  if(listIterator.hasNext()) {
        				  System.out.println("Now playing "+listIterator.next().toString());
        			  }else {
        				  if(listIterator.hasPrevious()) {
        					  System.out.println("Now Playing "+listIterator.previous().toString());
        					  
        				  }
        			  }
        		  }
        	  }
          }
          }

	public static void printMenu() {
		System.out.println("Available Options \n Press :");
		System.out.println("0- To quite \n" + 
		"1- To play next Song \n" +
		"2- To play Previous song \n"+
		"3- To replay the song \n" +
		"4- To get the List of all songs \n"+
		"5- To Print available options \n" +
		"6- To delete the song \n" );
	}
	public static void printList(LinkedList<Song> PlayList) {
		Iterator<Song> iterator=PlayList.iterator();
		System.out.println("________________________");
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("________________________");
		
	}

}
