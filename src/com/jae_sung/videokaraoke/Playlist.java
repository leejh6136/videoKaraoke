/*
 * This file is part of VideoKaraoke.
 *
 * VideoKaraoke is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * VideoKaraoke is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with VideoKaraoke.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright (c) 2020, LEE Jae-Sung.
 */

package com.jae_sung.videokaraoke;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Playlist {
	private ArrayList<Song> m_listSong;
	
	public Playlist(String strFilePath) {
		m_listSong = new ArrayList<>();
		readFile(strFilePath);
	}
	
	public Song searchSong(int nNum) {
		Song song = null;
		if(nNum != -1) {
			for(int i=0; i<m_listSong.size();i++) {
				if(m_listSong.get(i).getNum() == nNum) {
					song = m_listSong.get(i);
					break;
				}
			}
		}
		return song;
	}
	
	private void readFile(String strFilePath) {
		try{
            File file = new File(strFilePath);
            FileReader filereader = new FileReader(file);
            BufferedReader bufReader = new BufferedReader(filereader);
            String strLine = "";
            Song temp = null;
            int nCnt = 0;
            while((strLine = bufReader.readLine()) != null){
            	if(strLine.isEmpty() || strLine.charAt(0) == '#')
            		continue;
            	
            	if(temp == null) {
            		int nNum = Integer.valueOf(strLine);
            		temp = new Song();
            		temp.setNum(nNum);
            		nCnt = 0;
            	}
            	else {
            		switch(nCnt) {
            		case 0:
            			temp.setName(strLine);
            			break;
            		case 1:
            			temp.setArtist(strLine);
            			break;
            		case 2:
            		default:
            			temp.setFilePath(strLine);
            			m_listSong.add(temp);
            			temp = null;
            			break;
            		}
            		nCnt++;
            	}
            }         
            bufReader.close();
        }catch (FileNotFoundException e) {
            // TODO: handle exception
        }catch(IOException e){
            System.out.println(e);
        }
	}
}
