/**
 *   This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *	 
 */
package id.web.fai.comm.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleClient {
	public static void main(String[] args) {
		Socket socket=null;
		PrintWriter out=null;
		BufferedReader br=null;
		try {
			socket=new Socket("localhost",8888);
			out=new PrintWriter(socket.getOutputStream(),true);
			br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		BufferedReader stdIn=new BufferedReader(new InputStreamReader(System.in));
		String input;
		try {
			while((input=stdIn.readLine())!=null){
				out.println(input);
				System.out.println(br.readLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
