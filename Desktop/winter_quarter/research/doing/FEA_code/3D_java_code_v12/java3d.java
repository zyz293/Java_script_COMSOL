/*
 * java3d.java
 */

import com.comsol.model.*;
import com.comsol.model.util.*;

/** Model exported on Oct 20 2015, 21:22 by COMSOL 4.3.2.152. */
public class java3d {

  public static void main(String[] args) {
    run();
  }

  public static Model run() {
    Model model = ModelUtil.create("Model");

    model.modelPath("/home/zyz293/javacode/3D_java_code_v10");

    model.modelNode().create("mod1");

    model.geom().create("geom1", 3);
    model.geom("geom1").lengthUnit("mm");

    model.variable().create("var1");
    model.variable("var1").model("mod1");
    model.variable("var1")
         .set("ep", "+0.132/(1+(10^(-5.900)*ec.freq/1[Hz])^2)+0.064/(1+(10^(-5.319)*ec.freq/1[Hz])^2)+0.103/(1+(10^(-4.738)*ec.freq/1[Hz])^2)+0.090/(1+(10^(-4.155)*ec.freq/1[Hz])^2)+0.086/(1+(10^(-3.573)*ec.freq/1[Hz])^2)+0.066/(1+(10^(-2.991)*ec.freq/1[Hz])^2)+0.030/(1+(10^(-2.409)*ec.freq/1[Hz])^2)+0.025/(1+(10^(-1.827)*ec.freq/1[Hz])^2)+0.030/(1+(10^(-1.245)*ec.freq/1[Hz])^2)+0.024/(1+(10^(-0.664)*ec.freq/1[Hz])^2)+0.023/(1+(10^(-0.081)*ec.freq/1[Hz])^2)+0.023/(1+(10^(0.501)*ec.freq/1[Hz])^2)+0.023/(1+(10^(1.083)*ec.freq/1[Hz])^2)+0.021/(1+(10^(1.665)*ec.freq/1[Hz])^2)+0.042/(1+(10^(2.246)*ec.freq/1[Hz])^2)+-0.018/(1+(10^(2.829)*ec.freq/1[Hz])^2)+0.185/(1+(10^(3.410)*ec.freq/1[Hz])^2)+0.149/(1+(10^(3.993)*ec.freq/1[Hz])^2)+0.549/(1+(10^(4.574)*ec.freq/1[Hz])^2)+0.063/(1+(10^(5.155)*ec.freq/1[Hz])^2)+0.217/(1+(10^(5.739)*ec.freq/1[Hz])^2)+-0.557/(1+(10^(6.320)*ec.freq/1[Hz])^2)+3.100");
    model.variable("var1")
         .set("epp", "+0.132*(10^(-5.900)*ec.freq/1[Hz])/(1+(10^(-5.900)*ec.freq/1[Hz])^2)+0.064*(10^(-5.319)*ec.freq/1[Hz])/(1+(10^(-5.319)*ec.freq/1[Hz])^2)+0.103*(10^(-4.738)*ec.freq/1[Hz])/(1+(10^(-4.738)*ec.freq/1[Hz])^2)+0.090*(10^(-4.155)*ec.freq/1[Hz])/(1+(10^(-4.155)*ec.freq/1[Hz])^2)+0.086*(10^(-3.573)*ec.freq/1[Hz])/(1+(10^(-3.573)*ec.freq/1[Hz])^2)+0.066*(10^(-2.991)*ec.freq/1[Hz])/(1+(10^(-2.991)*ec.freq/1[Hz])^2)+0.030*(10^(-2.409)*ec.freq/1[Hz])/(1+(10^(-2.409)*ec.freq/1[Hz])^2)+0.025*(10^(-1.827)*ec.freq/1[Hz])/(1+(10^(-1.827)*ec.freq/1[Hz])^2)+0.030*(10^(-1.245)*ec.freq/1[Hz])/(1+(10^(-1.245)*ec.freq/1[Hz])^2)+0.024*(10^(-0.664)*ec.freq/1[Hz])/(1+(10^(-0.664)*ec.freq/1[Hz])^2)+0.023*(10^(-0.081)*ec.freq/1[Hz])/(1+(10^(-0.081)*ec.freq/1[Hz])^2)+0.023*(10^(0.501)*ec.freq/1[Hz])/(1+(10^(0.501)*ec.freq/1[Hz])^2)+0.023*(10^(1.083)*ec.freq/1[Hz])/(1+(10^(1.083)*ec.freq/1[Hz])^2)+0.021*(10^(1.665)*ec.freq/1[Hz])/(1+(10^(1.665)*ec.freq/1[Hz])^2)+0.042*(10^(2.246)*ec.freq/1[Hz])/(1+(10^(2.246)*ec.freq/1[Hz])^2)+-0.018*(10^(2.829)*ec.freq/1[Hz])/(1+(10^(2.829)*ec.freq/1[Hz])^2)+0.185*(10^(3.410)*ec.freq/1[Hz])/(1+(10^(3.410)*ec.freq/1[Hz])^2)+0.149*(10^(3.993)*ec.freq/1[Hz])/(1+(10^(3.993)*ec.freq/1[Hz])^2)+0.549*(10^(4.574)*ec.freq/1[Hz])/(1+(10^(4.574)*ec.freq/1[Hz])^2)+0.063*(10^(5.155)*ec.freq/1[Hz])/(1+(10^(5.155)*ec.freq/1[Hz])^2)+0.217*(10^(5.739)*ec.freq/1[Hz])/(1+(10^(5.739)*ec.freq/1[Hz])^2)+-0.557*(10^(6.320)*ec.freq/1[Hz])/(1+(10^(6.320)*ec.freq/1[Hz])^2)");
    model.variable("var1")
         .set("epint", "+0.132*DS1/(1+(10^(-5.900)*TS1*ec.freq/1[Hz])^2)+0.064*DS1/(1+(10^(-5.319)*TS1*ec.freq/1[Hz])^2)+0.103*DS1/(1+(10^(-4.738)*TS1*ec.freq/1[Hz])^2)+0.090*DS1/(1+(10^(-4.155)*TS1*ec.freq/1[Hz])^2)+0.086*DS1/(1+(10^(-3.573)*TS1*ec.freq/1[Hz])^2)+0.066*DS1/(1+(10^(-2.991)*TS1*ec.freq/1[Hz])^2)+0.030*DS1/(1+(10^(-2.409)*TS1*ec.freq/1[Hz])^2)+0.025*DS1/(1+(10^(-1.827)*TS1*ec.freq/1[Hz])^2)+0.030*DS1/(1+(10^(-1.245)*TS1*ec.freq/1[Hz])^2)+0.024*DS2/(1+(10^(-0.664)*TS2*ec.freq/1[Hz])^2)+0.023*DS2/(1+(10^(-0.081)*TS2*ec.freq/1[Hz])^2)+0.023*DS2/(1+(10^(0.501)*TS2*ec.freq/1[Hz])^2)+0.023*DS2/(1+(10^(1.083)*TS2*ec.freq/1[Hz])^2)+0.021*DS2/(1+(10^(1.665)*TS2*ec.freq/1[Hz])^2)+0.042*DS2/(1+(10^(2.246)*TS2*ec.freq/1[Hz])^2)+-0.018*DS2/(1+(10^(2.829)*TS2*ec.freq/1[Hz])^2)+0.185*DS2/(1+(10^(3.410)*TS2*ec.freq/1[Hz])^2)+0.149*DS2/(1+(10^(3.993)*TS2*ec.freq/1[Hz])^2)+0.549*DS2/(1+(10^(4.574)*TS2*ec.freq/1[Hz])^2)+0.063*DS2/(1+(10^(5.155)*TS2*ec.freq/1[Hz])^2)+0.217*DS2/(1+(10^(5.739)*TS2*ec.freq/1[Hz])^2)+-0.557*DS2/(1+(10^(6.320)*TS2*ec.freq/1[Hz])^2)+3.100+const");
    model.variable("var1")
         .set("eppint", "+0.132*DS1*(10^(-5.900)*TS1*ec.freq/1[Hz])/(1+(10^(-5.900)*TS1*ec.freq/1[Hz])^2)+0.064*DS1*(10^(-5.319)*TS1*ec.freq/1[Hz])/(1+(10^(-5.319)*TS1*ec.freq/1[Hz])^2)+0.103*DS1*(10^(-4.738)*TS1*ec.freq/1[Hz])/(1+(10^(-4.738)*TS1*ec.freq/1[Hz])^2)+0.090*DS1*(10^(-4.155)*TS1*ec.freq/1[Hz])/(1+(10^(-4.155)*TS1*ec.freq/1[Hz])^2)+0.086*DS1*(10^(-3.573)*TS1*ec.freq/1[Hz])/(1+(10^(-3.573)*TS1*ec.freq/1[Hz])^2)+0.066*DS1*(10^(-2.991)*TS1*ec.freq/1[Hz])/(1+(10^(-2.991)*TS1*ec.freq/1[Hz])^2)+0.030*DS1*(10^(-2.409)*TS1*ec.freq/1[Hz])/(1+(10^(-2.409)*TS1*ec.freq/1[Hz])^2)+0.025*DS1*(10^(-1.827)*TS1*ec.freq/1[Hz])/(1+(10^(-1.827)*TS1*ec.freq/1[Hz])^2)+0.030*DS1*(10^(-1.245)*TS1*ec.freq/1[Hz])/(1+(10^(-1.245)*TS1*ec.freq/1[Hz])^2)+0.024*DS2*(10^(-0.664)*TS2*ec.freq/1[Hz])/(1+(10^(-0.664)*TS2*ec.freq/1[Hz])^2)+0.023*DS2*(10^(-0.081)*TS2*ec.freq/1[Hz])/(1+(10^(-0.081)*TS2*ec.freq/1[Hz])^2)+0.023*DS2*(10^(0.501)*TS2*ec.freq/1[Hz])/(1+(10^(0.501)*TS2*ec.freq/1[Hz])^2)+0.023*DS2*(10^(1.083)*TS2*ec.freq/1[Hz])/(1+(10^(1.083)*TS2*ec.freq/1[Hz])^2)+0.021*DS2*(10^(1.665)*TS2*ec.freq/1[Hz])/(1+(10^(1.665)*TS2*ec.freq/1[Hz])^2)+0.042*DS2*(10^(2.246)*TS2*ec.freq/1[Hz])/(1+(10^(2.246)*TS2*ec.freq/1[Hz])^2)+-0.018*DS2*(10^(2.829)*TS2*ec.freq/1[Hz])/(1+(10^(2.829)*TS2*ec.freq/1[Hz])^2)+0.185*DS2*(10^(3.410)*TS2*ec.freq/1[Hz])/(1+(10^(3.410)*TS2*ec.freq/1[Hz])^2)+0.149*DS2*(10^(3.993)*TS2*ec.freq/1[Hz])/(1+(10^(3.993)*TS2*ec.freq/1[Hz])^2)+0.549*DS2*(10^(4.574)*TS2*ec.freq/1[Hz])/(1+(10^(4.574)*TS2*ec.freq/1[Hz])^2)+0.063*DS2*(10^(5.155)*TS2*ec.freq/1[Hz])/(1+(10^(5.155)*TS2*ec.freq/1[Hz])^2)+0.217*DS2*(10^(5.739)*TS2*ec.freq/1[Hz])/(1+(10^(5.739)*TS2*ec.freq/1[Hz])^2)+-0.557*DS2*(10^(6.320)*TS2*ec.freq/1[Hz])/(1+(10^(6.320)*TS2*ec.freq/1[Hz])^2)");

    model.geom("geom1").feature().create("blk1", "Block");
    model.geom("geom1").run("blk1");
    model.geom("geom1").feature("blk1")
         .set("size", new double[]{5.7361376676E-4, 5.7361376676E-4, 5.7361376676E-4});
    model.geom("geom1").feature("blk1").set("createselection", "on");
    model.geom("geom1").run();

    model.physics().create("ec", "ConductiveMedia", "geom1");
    model.physics("ec").feature("init1").set("V", 1, "1E-5");
    model.physics("ec").feature().create("gnd1", "Ground", 2);
    model.physics("ec").feature("gnd1").selection().set(new int[]{4});
    model.physics("ec").feature().create("pc1", "PeriodicCondition", 2);
    model.physics("ec").feature("pc1").selection().set(new int[]{1, 6});
    model.physics("ec").feature().create("term1", "Terminal", 2);
    model.physics("ec").feature("term1").selection().set(new int[]{3});
    model.physics("ec").feature("term1").set("TerminalType", 1, "Voltage");
    model.physics("ec").feature("term1").set("V0", 1, "0.1");
    model.physics("ec").feature("init1").set("V", 1, 1.0E-5);
    model.physics("ec").feature("term1").set("V0", 1, 0.0015);

    model.geom("geom1").feature().create("Ellipse0", "Ellipsoid");
    model.geom("geom1").feature("Ellipse0")
         .set("pos", new double[]{6.500956024809637E-5, 6.500956024809637E-5, 6.500956024809637E-5});
    model.geom("geom1").feature("Ellipse0")
         .set("semiaxes", new double[]{7.648183572096367E-6, 3.824091763103633E-6, 3.824091763103633E-6});
    model.geom("geom1").feature("Ellipse0").set("rot", 20);
    model.geom("geom1").feature("Ellipse0").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse1", "Ellipsoid");
    model.geom("geom1").feature("Ellipse1")
         .set("pos", new double[]{1.3384321225929635E-4, 8.03059273464E-5, 8.03059273464E-5});
    model.geom("geom1").feature("Ellipse1")
         .set("semiaxes", new double[]{7.648183572096367E-6, 3.824091763103633E-6, 3.824091763103633E-6});
    model.geom("geom1").feature("Ellipse1").set("rot", 20);
    model.geom("geom1").feature("Ellipse1").set("createselection", "on");
    model.geom("geom1").run();
    model.geom("geom1").feature().create("UnionFiller", "Union");
    model.geom("geom1").feature("UnionFiller").selection("input")
         .set(new String[]{"Ellipse0", "Ellipse1"});
    model.geom("geom1").feature("UnionFiller").set("createselection", "on");
    model.geom("geom1").feature("UnionFiller").set("intbnd", "off");
    model.geom("geom1").run();
    model.geom("geom1").feature().create("EllipseIF10", "Ellipsoid");
    model.geom("geom1").feature("EllipseIF10")
         .set("pos", new double[]{6.500956024809637E-5, 6.500956024809637E-5, 6.500956024809637E-5});
    model.geom("geom1").feature("EllipseIF10")
         .set("semiaxes", new double[]{1.2648183572096367E-5, 8.824091763103633E-6, 8.824091763103633E-6});
    model.geom("geom1").feature("EllipseIF10").set("rot", 20);
    model.geom("geom1").feature("EllipseIF10").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF11", "Ellipsoid");
    model.geom("geom1").feature("EllipseIF11")
         .set("pos", new double[]{1.3384321225929635E-4, 8.03059273464E-5, 8.03059273464E-5});
    model.geom("geom1").feature("EllipseIF11")
         .set("semiaxes", new double[]{1.2648183572096367E-5, 8.824091763103633E-6, 8.824091763103633E-6});
    model.geom("geom1").feature("EllipseIF11").set("rot", 20);
    model.geom("geom1").feature("EllipseIF11").set("createselection", "on");
    model.geom("geom1").run();
    model.geom("geom1").feature().create("UnionLargeEllipse1", "Union");
    model.geom("geom1").feature("UnionLargeEllipse1").selection("input")
         .set(new String[]{"EllipseIF10", "EllipseIF11"});
    model.geom("geom1").feature("UnionLargeEllipse1")
         .set("createselection", "on");
    model.geom("geom1").feature("UnionLargeEllipse1").set("intbnd", "off");
    model.geom("geom1").run();
    model.geom("geom1").feature().create("DiffInterface1", "Difference");
    model.geom("geom1").feature("DiffInterface1").selection("input")
         .set(new String[]{"UnionLargeEllipse1"});
    model.geom("geom1").feature("DiffInterface1").selection("input2")
         .set(new String[]{"UnionFiller"});
    model.geom("geom1").feature("DiffInterface1").set("keep", "on");
    model.geom("geom1").feature("DiffInterface1")
         .set("createselection", "on");
    model.geom("geom1").feature("DiffInterface1").set("intbnd", "off");
    model.geom("geom1").run();
    model.geom("geom1").feature().create("EllipseIF20", "Ellipsoid");
    model.geom("geom1").feature("EllipseIF20")
         .set("pos", new double[]{6.500956024809637E-5, 6.500956024809637E-5, 6.500956024809637E-5});
    model.geom("geom1").feature("EllipseIF20")
         .set("semiaxes", new double[]{6.264818357209637E-5, 5.882409176310364E-5, 5.882409176310364E-5});
    model.geom("geom1").feature("EllipseIF20").set("rot", 20);
    model.geom("geom1").feature("EllipseIF20").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF21", "Ellipsoid");
    model.geom("geom1").feature("EllipseIF21")
         .set("pos", new double[]{1.3384321225929635E-4, 8.03059273464E-5, 8.03059273464E-5});
    model.geom("geom1").feature("EllipseIF21")
         .set("semiaxes", new double[]{6.264818357209637E-5, 5.882409176310364E-5, 5.882409176310364E-5});
    model.geom("geom1").feature("EllipseIF21").set("rot", 20);
    model.geom("geom1").feature("EllipseIF21").set("createselection", "on");
    model.geom("geom1").run();
    model.geom("geom1").feature().create("UnionLargeEllipse2", "Union");
    model.geom("geom1").feature("UnionLargeEllipse2").selection("input")
         .set(new String[]{"EllipseIF20", "EllipseIF21"});
    model.geom("geom1").feature("UnionLargeEllipse2")
         .set("createselection", "on");
    model.geom("geom1").feature("UnionLargeEllipse2").set("intbnd", "off");
    model.geom("geom1").run();
    model.geom("geom1").feature().create("DiffInterface2", "Difference");
    model.geom("geom1").feature("DiffInterface2").selection("input")
         .set(new String[]{"UnionLargeEllipse2"});
    model.geom("geom1").feature("DiffInterface2").selection("input2")
         .set(new String[]{"UnionLargeEllipse1"});
    model.geom("geom1").feature("DiffInterface2").set("keep", "on");
    model.geom("geom1").feature("DiffInterface2")
         .set("createselection", "on");
    model.geom("geom1").feature("DiffInterface2").set("intbnd", "off");
    model.geom("geom1").run();
    model.geom("geom1").feature().create("DiffMatrix", "Difference");
    model.geom("geom1").feature("DiffMatrix").selection("input")
         .set(new String[]{"blk1"});
    model.geom("geom1").feature("DiffMatrix").selection("input2")
         .set(new String[]{"UnionLargeEllipse2"});
    model.geom("geom1").feature("DiffMatrix").set("keep", "on");
    model.geom("geom1").feature("DiffMatrix").set("createselection", "on");
    model.geom("geom1").run();

    model.material().create("mat1");
    model.material("mat1").selection().named("geom1_UnionFiller_dom");
    model.material("mat1").propertyGroup("def")
         .set("electricconductivity", 1.0E-15);
    model.material("mat1").propertyGroup("def").set("relpermittivity", 3.9);
    model.material().create("mat2");
    model.material("mat2").selection().named("geom1_DiffMatrix_dom");
    model.material().create("mat4");
    model.material("mat4").selection().named("geom1_DiffInterface1_dom");
    model.material().create("mat5");
    model.material("mat5").selection().named("geom1_DiffInterface2_dom");
    model.material("mat2").propertyGroup("def")
         .set("relpermittivity", "ep-j*epp");
    model.material("mat2").propertyGroup("def")
         .set("electricconductivity", 1.0E-15);
    model.material("mat4").propertyGroup("def")
         .set("relpermittivity", "2.4-j*0.0010");
    model.material("mat4").propertyGroup("def")
         .set("electricconductivity", 1.0E-11);
    model.material("mat5").propertyGroup("def")
         .set("relpermittivity", "epint-j*eppint");
    model.material("mat5").propertyGroup("def")
         .set("electricconductivity", 1.0E-15);

    model.mesh().create("mesh1", "geom1");
    model.mesh("mesh1").autoMeshSize(5);
    model.mesh("mesh1").run();

    model.variable("var1").set("TS1", "1.0");
    model.variable("var1").set("DS1", "1.0");
    model.variable("var1").set("TS2", "1.0");
    model.variable("var1").set("DS2", "1.0");
    model.variable("var1").set("const", "0.0");

    model.study().create("std1");
    model.study("std1").feature().create("freq", "Frequency");
    model.study("std1").feature("freq").set("geomselection", "geom1");
    model.study("std1").feature("freq").set("physselection", "ec");
    model.study("std1").feature("freq")
         .set("plist", new double[]{0.0010, 0.001584893192461114, 0.0025118864315095794, 0.003981071705534973, 0.00630957344480193, 0.01, 0.01584893192461114, 0.025118864315095808, 0.039810717055349734, 0.06309573444801933, 0.1, 0.15848931924611143, 0.25118864315095824, 0.3981071705534973, 0.6309573444801937, 1, 1.5848931924611143, 2.5118864315095824, 3.981071705534973, 6.309573444801936, 10, 15.848931924611142, 25.11886431509582, 39.81071705534978, 63.09573444801943, 100, 158.48931924611142, 251.18864315095823, 398.1071705534977, 630.9573444801943, 1000, 1584.893192461114, 2511.886431509582, 3981.0717055349774, 6309.573444801943, 10000, 15848.93192461114, 25118.864315095823, 39810.71705534977, 63095.73444801943, 100000, 158489.31924611173, 251188.6431509582, 398107.1705534969, 630957.3444801943, 1000000});

    model.sol().create("sol1");
    model.sol("sol1").study("std1");
    model.sol("sol1").feature().create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "freq");
    model.sol("sol1").feature().create("v1", "Variables");
    model.sol("sol1").feature().create("s1", "Stationary");
    model.sol("sol1").feature("s1").feature().create("p1", "Parametric");
    model.sol("sol1").feature("s1").feature().remove("pDef");
    model.sol("sol1").feature("s1").feature("p1").set("pname", "freq");
    model.sol("sol1").feature("s1").feature("p1")
         .set("plist", new double[]{0.0010, 0.001584893192461114, 0.0025118864315095794, 0.003981071705534973, 0.00630957344480193, 0.01, 0.01584893192461114, 0.025118864315095808, 0.039810717055349734, 0.06309573444801933, 0.1, 0.15848931924611143, 0.25118864315095824, 0.3981071705534973, 0.6309573444801937, 1, 1.5848931924611143, 2.5118864315095824, 3.981071705534973, 6.309573444801936, 10, 15.848931924611142, 25.11886431509582, 39.81071705534978, 63.09573444801943, 100, 158.48931924611142, 251.18864315095823, 398.1071705534977, 630.9573444801943, 1000, 1584.893192461114, 2511.886431509582, 3981.0717055349774, 6309.573444801943, 10000, 15848.93192461114, 25118.864315095823, 39810.71705534977, 63095.73444801943, 100000, 158489.31924611173, 251188.6431509582, 398107.1705534969, 630957.3444801943, 1000000});
    model.sol("sol1").feature("s1").feature("p1").set("plot", "off");
    model.sol("sol1").feature("s1").feature("p1").set("probesel", "all");
    model.sol("sol1").feature("s1").feature("p1")
         .set("probes", new String[]{});
    model.sol("sol1").feature("s1").feature("p1").set("control", "freq");
    model.sol("sol1").feature("s1").set("control", "freq");
    model.sol("sol1").feature("s1").feature().create("fc1", "FullyCoupled");
    model.sol("sol1").feature("s1").feature().create("i1", "Iterative");
    model.sol("sol1").feature("s1").feature("i1")
         .set("linsolver", "bicgstab");
    model.sol("sol1").feature("s1").feature("fc1").set("linsolver", "i1");
    model.sol("sol1").feature("s1").feature("i1").feature()
         .create("mg1", "Multigrid");
    model.sol("sol1").feature("s1").feature("i1").feature("mg1")
         .set("prefun", "gmg");
    model.sol("sol1").feature("s1").feature().remove("fcDef");
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result().create("pg1", 3);
    model.result("pg1").set("data", "dset1");
    model.result("pg1").feature().create("slc1", "Slice");
    model.result("pg1").feature("slc1").set("expr", new String[]{"V"});
    model.result("pg1").feature("slc1").set("quickplane", "xy");
    model.result("pg1").feature("slc1").set("quickznumber", "1");
    model.result("pg1").feature().create("slc2", "Slice");
    model.result("pg1").feature("slc2").set("expr", new String[]{"V"});
    model.result("pg1").feature("slc2").set("quickplane", "yz");
    model.result("pg1").feature("slc2").set("quickxnumber", "1");
    model.result("pg1").feature("slc2").set("inheritplot", "slc1");
    model.result("pg1").feature().create("slc3", "Slice");
    model.result("pg1").feature("slc3").set("expr", new String[]{"V"});
    model.result("pg1").feature("slc3").set("quickplane", "zx");
    model.result("pg1").feature("slc3").set("quickynumber", "1");
    model.result("pg1").feature("slc3").set("inheritplot", "slc1");
    model.result("pg1").name("Electric Potential (ec)");
    model.result("pg1").run();
    model.result().numerical().create("av1", "AvSurface");
    model.result().numerical("av1").selection().set(new int[]{4});
    model.result().table().create("tbl1", "Table");
    model.result().table("tbl1")
         .comments("Surf Average 1, Epsilon Double Prime");
    model.result().numerical("av1").set("table", "tbl1");
    model.result().numerical("av1")
         .set("expr", "real(ec.Jy/0.002[V])*0.001[mm]/ec.freq/2/3.14/8.85e-12[F/m]");
    model.result().numerical("av1").set("descr", "Epsilon Double Prime");
    model.result().numerical("av1").setResult();
    model.result().create("pg2", 1);
    model.result("pg2").feature().create("tblp1", "Table");
    model.result("pg2").feature("tblp1").set("table", "tbl1");
    model.result("pg2").run();
    model.result().export().create("plot1", "pg2", "tblp1", "Plot");
    model.result().export("plot1").set("header", "off");
    model.result().export("plot1")
         .set("filename", "./HZ_3D_comsolbuild_AC_recon_2015/10/20_15:15:57_IP5.0+50.0_run_1.0_CompPermImag.csv");
    model.result().numerical().create("av2", "AvSurface");
    model.result().numerical("av2").selection().set(new int[]{4});
    model.result().table().create("tbl2", "Table");
    model.result().table("tbl2").comments("Surf Average 2, Epsilon Prime");
    model.result().numerical("av2").set("table", "tbl2");
    model.result().numerical("av2")
         .set("expr", "imag(ec.Jy/0.002[V])*0.001[mm]/ec.freq/2/3.14/8.85e-12[F/m]");
    model.result().numerical("av2").set("descr", "Epsilon Prime");
    model.result().numerical("av2").setResult();
    model.result().create("pg3", 1);
    model.result("pg3").feature().create("tblp2", "Table");
    model.result("pg3").feature("tblp2").set("table", "tbl2");
    model.result("pg3").run();
    model.result().export().create("plot2", "pg3", "tblp2", "Plot");
    model.result().export("plot2").set("header", "off");
    model.result().export("plot2")
         .set("filename", "./HZ_3D_comsolbuild_AC_recon_2015/10/20_15:15:57_IP5.0+50.0_run_1.0_CompPermReal.csv");

    model.name("Comsol3Dcode_Model.mph");
    model.name("Comsol3Dcode_Model.mph");

    return model;
  }

}
