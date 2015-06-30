package jp.ac.it_college.std.s14004;

import jp.ac.it_college.std.nakasone.lib.exam.Communicator;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by s14003 on 15/06/30.
 */

public class Main {
    public static void main(String... args) {
        Communicator comm = new Communicator((msg) -> {
            System.out.println(msg);
        });

        comm.start();

        while(true) {
            Scanner stdIn = new Scanner(System.in);
            System.out.println("メッセージを入力してください");
            String message = stdIn.next();
            if (message.equals("exit")) {
                try {
                    comm.send("切断しました");
                    break;

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
                try {
                    comm.send(message);
                } catch (IOException var3) {
                    var3.printStackTrace();
                }

            }
        }

    }
}
