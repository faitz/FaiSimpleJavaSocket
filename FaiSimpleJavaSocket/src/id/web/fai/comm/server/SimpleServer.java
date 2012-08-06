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
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
	public static void main(String[] args) {
		ServerSocket server=null;
		try {
			server=new ServerSocket(8888);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(server==null)System.exit(1);

		try {
			Socket client=server.accept();
			PrintWriter out=new PrintWriter(client.getOutputStream(),true);
			BufferedReader br=new BufferedReader(new InputStreamReader(client.getInputStream()));
			String input;
			while((input=br.readLine())!=null){
				out.println("echo:"+input);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
