package by.epam.jamp.module6.main.PermGenError.generotor;

import by.epam.jamp.module6.main.MemoryTest;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;

public class PermGenErrorGenerator implements MemoryTest {

	static ClassPool cp = ClassPool.getDefault();

	public void runTest() {
		for (int i = 0;; i++) {
			CtClass c = cp.makeClass("by.epam.jamp.module6.main.PermGenError.generotor.tmp.A" + i);

			try {
//				StringBuilder sb = new StringBuilder();
//				sb.append("public int xmove(long dx) {");
//				for (int j = 0; j < 6; j++) {
//					//sb.append("long[] xy1"+j+" =  new long[300000]; ");
//					sb.append("long x"+j+" =  dx; ");	
//				}
//				
//				sb.append("return 1;}");
//				CtMethod m = CtNewMethod.make(sb.toString(), c);
				
				Class clazz = c.toClass();
				
				System.out.println("Class created: " + c);
				
			} catch (CannotCompileException e) {
				System.out.println("xxxxxxxxxxxxxx");
				e.printStackTrace();
			}
			
			
		}
	}

}
