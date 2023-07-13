import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Iterator;

public class Program
{
	private static final char[] HEX = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
	private static final String SIGNATURE_FILE = "signatures.txt";
	private static final String RESULT_FILE = "result.txt";
	private static final String NOT_FOUND = "File not found.";

	public static void main( String[] args )
	{
		Map <String, String> dictionary = readSignatureFile();
		Scanner scan = new Scanner( System.in );
		String	inLine = scan.nextLine();

		while ( !inLine.equals( "42" ) )
		{
			checkFile( inLine, dictionary );
			inLine = scan.nextLine();
		}
		scan.close();
	}

	public static Map<String, String> readSignatureFile()
	{
		FileInputStream inFile;
		Map <String, String> dictionary = new HashMap<>();

		try
		{
			inFile = new FileInputStream( SIGNATURE_FILE );
			Scanner scan = new Scanner( inFile );

			while ( scan.hasNextLine() )
			{
				String line = scan.nextLine();
				String[] elem = line.split(",");
				dictionary.put(elem[0], elem[1].replaceAll("\\s+", ""));
			}
			scan.close();
			inFile.close();
		}
		catch ( Exception e )
		{
			System.err.println( NOT_FOUND );
			System.exit( -1 );
		}

		return ( dictionary );
	}

	public static void checkFile( String inLine, Map<String, String> dictionary )
	{
		try ( FileInputStream inFile = new FileInputStream( inLine ) )
		{
			byte[] bytes = new byte[8];
			inFile.read( bytes, 0, 8 );
			String fileSignature = bytesToHex( bytes );
			findSignature( fileSignature, dictionary );
		}
		catch ( Exception e )
		{
			System.err.println( NOT_FOUND );
		}
	}

	public static String bytesToHex( byte[] bytes )
	{
		char[] hexChars = new char[bytes.length * 2];

		for ( int j = 0; j < bytes.length; j++ ) 
		{
			int v = bytes[j] & 0xFF;
			hexChars[j * 2] = HEX[v >>> 4];
			hexChars[j * 2 + 1] = HEX[v & 0x0F];
		}
		return new String( hexChars );
	}

	public static void findSignature( String signature, Map<String, String> dictionary )
	{
		try ( FileOutputStream fileOutputStream = new FileOutputStream( RESULT_FILE, true ) )
		{
			Iterator<Map.Entry<String, String>> iter = dictionary.entrySet().iterator();
			while ( iter.hasNext() )
			{
				Map.Entry<String, String> fileSignature = iter.next();
				if ( signature.contains( fileSignature.getValue() ) )
				{
					fileOutputStream.write( fileSignature.getKey().getBytes() );
					fileOutputStream.write( '\n' );
					System.out.println( "PROCESSED" );
					return ;
				}
			}
			System.out.println( "UNDEFINED"  );
		}
		catch ( Exception e )
		{
			System.err.println( NOT_FOUND );
		}
	}
}
