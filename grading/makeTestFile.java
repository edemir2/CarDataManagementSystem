class makeTestFile
{
	public static void main(String[] args)
	{
		if( args.length != 2 )
		{
			System.out.println("format: makeTestFile \"test file\" \"user name\"");
			System.exit(0);
		}
		
		try
		{
			java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(args[0])));
			String inn;
			java.util.ArrayList<String> lines = new java.util.ArrayList<>();
			while( (inn = input.readLine()) != null )
			{
				if( inn.indexOf("bailey_") > 0 )
				{
					System.out.print("replacing " + inn + " with ");
					inn = inn.replace(" bailey_", " " + args[1] + "_");
					System.out.println(inn);
				}
				
				if( inn.indexOf("testing bailey") > 0 )
				{
					System.out.print("replacing " + inn + " with ");
					inn = inn.replace("testing bailey", "testing " + args[1]);
					System.out.println(inn);
				}
								
				if( inn.indexOf("print(\"testResults =") > 0 )
				{
					System.out.print("replacing " + inn + " with ");
					inn = inn.replace("print(\"testResults =", "print(\"" + args[1]);
					System.out.println(inn);
				}
								
				lines.add(inn);
			}
			input.close();
			
			if( true )
			{
				java.io.PrintWriter output = new java.io.PrintWriter(new java.io.BufferedWriter(new java.io.FileWriter(args[1] + "_" + args[0])));
				for( String currentLine : lines )
				{
					output.println(currentLine);
				}
				output.close();
			}
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			System.exit(0);
		}
	}
}
