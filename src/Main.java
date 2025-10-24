import java.util.Random;

public class Main {
    private static final String[] MESSAGES = {
            "Initializing virtual environment...",
            "Loading modules: net.olympus, sec.core, ui.render",
            "Establishing secure channel...",
            "Authenticating user...",
            "Access granted (simulated).",
            "Scanning directories...",
            "Generating hex dump...",
            "Operation complete."
    };

    public static void main(String[] args) throws InterruptedException {
        typeHeader();
        randomActivityLoop(8);
        hexDumpSimulation();
        footer();
    }

    private static void typeHeader() throws InterruptedException {
        String title = "=== HACKER CONSOLE SIMULATOR (SIMULATED OUTPUT) ===";
        typeLine(title, 6);
        Thread.sleep(300);
    }

    private static void typeLine(String line, int delayMs) throws InterruptedException {
        for (char c : line.toCharArray()) {
            System.out.print(c);
            Thread.sleep(delayMs);
        }
        System.out.println();
    }

    private static void randomActivityLoop(int iterations) throws InterruptedException {
        Random rnd = new Random();
        for (int i = 0; i < iterations; i++) {
            String msg = MESSAGES[rnd.nextInt(MESSAGES.length)];
            typeLine("[*] " + msg, 8);
            // simulate progress bar
            simulateProgressBar(30 + rnd.nextInt(40));
            Thread.sleep(250);
        }
    }

    private static void simulateProgressBar(int width) throws InterruptedException {
        System.out.print("[");
        for (int i = 0; i < width; i++) {
            System.out.print("=");
            Thread.sleep(6);
        }
        System.out.println("] 100%");
    }

    // produce a fake hex dump for aesthetics
    private static void hexDumpSimulation() throws InterruptedException {
        Random rnd = new Random();
        System.out.println("\n--- HEX DUMP (SIMULATED) ---");
        for (int line = 0; line < 12; line++) {
            StringBuilder address = new StringBuilder();
            address.append(String.format("%08X: ", 0x1000 + line * 16));
            StringBuilder hexPart = new StringBuilder();
            StringBuilder asciiPart = new StringBuilder();
            for (int i = 0; i < 16; i++) {
                int b = rnd.nextInt(256);
                hexPart.append(String.format("%02X ", b));
                asciiPart.append((b >= 32 && b < 127) ? (char)b : '.');
            }
            String out = address + hexPart.toString() + " | " + asciiPart.toString();
            System.out.println(out);
            Thread.sleep(120);
        }
        System.out.println("--- END OF DUMP ---\n");
    }


    private static void footer() throws InterruptedException {
        typeLine("Note: This is only a simulation. Do not attempt illegal activities.", 6);
        typeLine("Credits: DocumentationPractice - For learning & demo purposes.", 6);
    }
}
