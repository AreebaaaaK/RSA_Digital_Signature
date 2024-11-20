import java.util.Scanner;
public class RSAKeys{
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);

        long e = 65537;
        long n = 10807;
        long d = 2873;

        System.out.println("Public key (e, n): (" + e + ", " + n + ")");
        System.out.println("Private key (d, n): (" + d + ", " + n + ")");

        System.out.print("Enter a message (text): ");
        String message = scanner.nextLine();

        System.out.println("\nEncrypted message:");
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            long encryptedChar = modExp(ch, e, n);
            System.out.println("Chunk " + ch + ": " + encryptedChar);
        }

        System.out.println("\nDecrypted message:");
        StringBuilder decryptedMessage = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            long encryptedChar = modExp(ch, e, n);
            char decryptedChar = (char) modExp(encryptedChar, d, n);
            decryptedMessage.append(decryptedChar);
        }

        System.out.println(decryptedMessage);
        if (message.equals(decryptedMessage.toString())) {
            System.out.println("Success! Decrypted message matches the original.");
        } else {
            System.out.println("Failure! Decrypted message does not match the original.");
        }

        System.out.println("\nDigital Signature (Signed Hash of Message):");
        long signature = modExp(hashMessage(message), d, n);
        System.out.println(signature);

        long originalHash = hashMessage(message);
        System.out.println("Original Hash: " + originalHash);

        long decryptedSignature = modExp(signature, e, n);
        System.out.println("Decrypted Signature: " + decryptedSignature);

        if (decryptedSignature == originalHash) {
            System.out.println("Signature valid: true");
        } else {
            System.out.println("Signature valid: false");
        }
    }

    public static long modExp(long base, long exp, long mod) {j
        long result = 1;
        base = base % mod;
        while (exp > 0) {
            if (exp % 2 == 1) {c
                result = (result * base) % mod;
            }
            exp = exp >> 1;
            base = (base * base) % mod;
        }
        return result;
    }

    public static long hashMessage(String message) {
        long hash = 0;
        for (int i = 0; i < message.length(); i++) {
            hash += message.charAt(i);
        }
        return hash;
    }
}
