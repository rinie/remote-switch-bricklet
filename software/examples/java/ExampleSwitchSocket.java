import com.tinkerforge.BrickletRemoteSwitch;
import com.tinkerforge.IPConnection;

public class ExampleSwitchSocket {
	private static final String HOST = "localhost";
	private static final int PORT = 4223;
	private static final String UID = "XYZ"; // Change to your UID

	// Note: To make the example code cleaner we do not handle exceptions. Exceptions you
	//       might normally want to catch are described in the documentation
	public static void main(String args[]) throws Exception {
		IPConnection ipcon = new IPConnection(); // Create IP connection
		BrickletRemoteSwitch rs = new BrickletRemoteSwitch(UID, ipcon); // Create device object

		ipcon.connect(HOST, PORT); // Connect to brickd
		// Don't use device before ipcon is connected

		// Switch on a type A socket with house code 17 and receiver code 1.
		// House code 17 is 10001 in binary (least-significant bit first)
		// and means that the DIP switches 1 and 5 are on and 2-4 are off.
		// Receiver code 1 is 10000 in binary (least-significant bit first)
		// and means that the DIP switch A is on and B-E are off.
		rs.switchSocketA((short)17, (short)1, BrickletRemoteSwitch.SWITCH_TO_ON);

		System.out.println("Press key to exit"); System.in.read();
		ipcon.disconnect();
	}
}
