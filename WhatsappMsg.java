package java_array;
// import java.awt.AWTException;
// import java.awt.Robot;
// import java.awt.Toolkit;
// import java.awt.datatransfer.Clipboard;
// import java.awt.datatransfer.StringSelection;
// import java.awt.event.KeyEvent;
// import java.util.Scanner;

// public class WhatsappMsg {

//     public static void main(String[] args) throws AWTException, InterruptedException {
//         // Create a scanner to read input from the user
//         Scanner scanner = new Scanner(System.in);
//         System.out.println("Enter the message:");
//         String msg = scanner.nextLine();

//         System.out.println("How many times do you want to send the message?");
//         int size = scanner.nextInt();

//         StringSelection stringSelection = new StringSelection(msg);
//         Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//         clipboard.setContents(stringSelection, null);

//         Thread.sleep(3000);

//         Robot robot = new Robot();

//         for (int i = 0; i < size; i++) {
//             robot.keyPress(KeyEvent.VK_CONTROL);
//             robot.keyPress(KeyEvent.VK_V);
//             robot.keyRelease(KeyEvent.VK_V);
//             robot.keyRelease(KeyEvent.VK_CONTROL);

//             robot.keyPress(KeyEvent.VK_ENTER);
//             robot.keyRelease(KeyEvent.VK_ENTER);

//             Thread.sleep(1000);
//         }
//         scanner.close();
//     }
// }
// import java.awt.AWTException;
// import java.awt.Robot;
// import java.awt.Toolkit;
// import java.awt.datatransfer.Clipboard;
// import java.awt.datatransfer.StringSelection;
// import java.awt.event.KeyEvent;
// import java.io.IOException;
// import java.util.Scanner;

// public class WhatsappMsg {

//     public static void main(String[] args) throws AWTException, InterruptedException, IOException {
//         // Create a scanner to read input from the user
//         Scanner scanner = new Scanner(System.in);
//         System.out.println("Enter the message:");
//         String msg = scanner.nextLine();

//         System.out.println("How many times do you want to send the message?");
//         int size = scanner.nextInt();

//         // Copy the message to the clipboard
//         StringSelection stringSelection = new StringSelection(msg);
//         Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//         clipboard.setContents(stringSelection, null);

//         // Construct the WhatsApp URL for the specific number
//         String phoneNumber = "9318377210";
//         String whatsappUrl = "https://web.whatsapp.com/send?phone=" + phoneNumber;

//         // Open the default web browser and navigate to the WhatsApp URL (Ubuntu version)
//         Runtime.getRuntime().exec("xdg-open " + whatsappUrl);

//         // Wait for WhatsApp Web to load
//         Thread.sleep(10000); // Adjust this delay if necessary based on your internet speed

//         Robot robot = new Robot();

//         for (int i = 0; i < size; i++) {
//             // Simulate pressing Ctrl+V to paste the message
//             robot.keyPress(KeyEvent.VK_CONTROL);
//             robot.keyPress(KeyEvent.VK_V);
//             robot.keyRelease(KeyEvent.VK_V);
//             robot.keyRelease(KeyEvent.VK_CONTROL);

//             // Simulate pressing Enter to send the message
//             robot.keyPress(KeyEvent.VK_ENTER);
//             robot.keyRelease(KeyEvent.VK_ENTER);

//             // Wait for 1 second before sending the next message
//             Thread.sleep(1000);
//         }

//         // Close the scanner to avoid resource leak
//         scanner.close();
//     }
// }


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class WhatsappMsg {

    public static void main(String[] args) throws AWTException, InterruptedException, IOException {
        // Create a scanner to read input from the user
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the message:");
        String msg = scanner.nextLine();

        System.out.println("How many times do you want to send the message?");
        int size = scanner.nextInt();

        // Copy the message to the clipboard
        StringSelection stringSelection = new StringSelection(msg);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);

        // Construct the WhatsApp URL for the specific number
        String phoneNumber = "9318377210";
        String whatsappUrl = "https://web.whatsapp.com/send?phone=" + phoneNumber;

        // Open the default web browser and navigate to the WhatsApp URL (Ubuntu version)
        Runtime.getRuntime().exec("xdg-open " + whatsappUrl);

        // Create a ScheduledExecutorService to handle the delay and scheduling
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // Define the task to be executed after the delay
        Runnable messageTask = new Runnable() {
            @Override
            public void run() {
                try {
                    // Wait for WhatsApp Web to load
                    Thread.sleep(10000); // Adjust this delay if necessary based on your internet speed

                    Robot robot = new Robot();

                    for (int i = 0; i < size; i++) {
                        // Simulate pressing Ctrl+V to paste the message
                        robot.keyPress(KeyEvent.VK_CONTROL);
                        robot.keyPress(KeyEvent.VK_V);
                        robot.keyRelease(KeyEvent.VK_V);
                        robot.keyRelease(KeyEvent.VK_CONTROL);

                        // Simulate pressing Enter to send the message
                        robot.keyPress(KeyEvent.VK_ENTER);
                        robot.keyRelease(KeyEvent.VK_ENTER);

                        // Wait for 1 second before sending the next message
                        Thread.sleep(1000);
                    }
                } catch (AWTException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // Schedule the task to be executed after a 1-minute delay
        scheduler.schedule(messageTask, 1, TimeUnit.MINUTES);

        // Close the scanner to avoid resource leak
        scanner.close();

        // Optionally, shut down the scheduler after the task is completed
        // scheduler.shutdown();
    }
}
