import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;

public class TestRSASignature {

    @Test
    public void testEncryptMessage() throws NoSuchAlgorithmException {
        RSAKeys keys = RSAKeys.generate(16);
        RSASignature signature = new RSASignature(keys);

        String message = "Hello World";
        BigInteger encryptedHash = signature.encryptMessage(message);
        BigInteger decryptedHash = signature.decrypt(encryptedHash);

        // Validate decrypted hash equals the original hash
        BigInteger expectedHash = new BigInteger(1, MessageDigest.getInstance("SHA-256").digest(message.getBytes()));
        assertEquals(expectedHash, decryptedHash);
    }
}
