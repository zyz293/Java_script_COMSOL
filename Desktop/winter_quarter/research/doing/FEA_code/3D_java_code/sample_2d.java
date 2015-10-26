/*
 * sample_2d.java
 */

import com.comsol.model.*;
import com.comsol.model.util.*;

/** Model exported on Aug 8 2015, 10:58 by COMSOL 4.2.0.150. */
public class sample_2d {

  public static void main(String[] args) {
    run();
  }

  public static Model run() {
    Model model = ModelUtil.create("Model");

    model.modelPath("E:\\hzhao\\comsol_api");

    model.modelNode().create("mod1");

    model.geom().create("geom1", 2);
    model.geom("geom1").lengthUnit("mm");

    model.variable().create("var1");
    model.variable("var1").model("mod1");
    model.variable("var1")
         .set("ep", "+0.132/(1+(10^(-5.9)*ec.freq/1[Hz])^2)+0.0643/(1+(10^(-5.32)*ec.freq/1[Hz])^2)+0.103/(1+(10^(-4.74)*ec.freq/1[Hz])^2)+0.0895/(1+(10^(-4.15)*ec.freq/1[Hz])^2)+0.0864/(1+(10^(-3.57)*ec.freq/1[Hz])^2)+0.066/(1+(10^(-2.99)*ec.freq/1[Hz])^2)+0.0299/(1+(10^(-2.41)*ec.freq/1[Hz])^2)+0.025/(1+(10^(-1.83)*ec.freq/1[Hz])^2)+0.0303/(1+(10^(-1.24)*ec.freq/1[Hz])^2)+0.0243/(1+(10^(-0.664)*ec.freq/1[Hz])^2)+0.0225/(1+(10^(-0.0809)*ec.freq/1[Hz])^2)+0.0231/(1+(10^(0.501)*ec.freq/1[Hz])^2)+0.0229/(1+(10^(1.08)*ec.freq/1[Hz])^2)+0.0207/(1+(10^(1.66)*ec.freq/1[Hz])^2)+0.0418/(1+(10^(2.25)*ec.freq/1[Hz])^2)+-0.0184/(1+(10^(2.83)*ec.freq/1[Hz])^2)+0.185/(1+(10^(3.41)*ec.freq/1[Hz])^2)+0.149/(1+(10^(3.99)*ec.freq/1[Hz])^2)+0.549/(1+(10^(4.57)*ec.freq/1[Hz])^2)+0.0629/(1+(10^(5.16)*ec.freq/1[Hz])^2)+0.217/(1+(10^(5.74)*ec.freq/1[Hz])^2)+-0.557/(1+(10^(6.32)*ec.freq/1[Hz])^2)+3.1");
    model.variable("var1")
         .set("epp", "+0.132*(10^(-5.9)*ec.freq/1[Hz])/(1+(10^(-5.9)*ec.freq/1[Hz])^2)+0.0643*(10^(-5.32)*ec.freq/1[Hz])/(1+(10^(-5.32)*ec.freq/1[Hz])^2)+0.103*(10^(-4.74)*ec.freq/1[Hz])/(1+(10^(-4.74)*ec.freq/1[Hz])^2)+0.0895*(10^(-4.15)*ec.freq/1[Hz])/(1+(10^(-4.15)*ec.freq/1[Hz])^2)+0.0864*(10^(-3.57)*ec.freq/1[Hz])/(1+(10^(-3.57)*ec.freq/1[Hz])^2)+0.066*(10^(-2.99)*ec.freq/1[Hz])/(1+(10^(-2.99)*ec.freq/1[Hz])^2)+0.0299*(10^(-2.41)*ec.freq/1[Hz])/(1+(10^(-2.41)*ec.freq/1[Hz])^2)+0.025*(10^(-1.83)*ec.freq/1[Hz])/(1+(10^(-1.83)*ec.freq/1[Hz])^2)+0.0303*(10^(-1.24)*ec.freq/1[Hz])/(1+(10^(-1.24)*ec.freq/1[Hz])^2)+0.0243*(10^(-0.664)*ec.freq/1[Hz])/(1+(10^(-0.664)*ec.freq/1[Hz])^2)+0.0225*(10^(-0.0809)*ec.freq/1[Hz])/(1+(10^(-0.0809)*ec.freq/1[Hz])^2)+0.0231*(10^(0.501)*ec.freq/1[Hz])/(1+(10^(0.501)*ec.freq/1[Hz])^2)+0.0229*(10^(1.08)*ec.freq/1[Hz])/(1+(10^(1.08)*ec.freq/1[Hz])^2)+0.0207*(10^(1.66)*ec.freq/1[Hz])/(1+(10^(1.66)*ec.freq/1[Hz])^2)+0.0418*(10^(2.25)*ec.freq/1[Hz])/(1+(10^(2.25)*ec.freq/1[Hz])^2)+-0.0184*(10^(2.83)*ec.freq/1[Hz])/(1+(10^(2.83)*ec.freq/1[Hz])^2)+0.185*(10^(3.41)*ec.freq/1[Hz])/(1+(10^(3.41)*ec.freq/1[Hz])^2)+0.149*(10^(3.99)*ec.freq/1[Hz])/(1+(10^(3.99)*ec.freq/1[Hz])^2)+0.549*(10^(4.57)*ec.freq/1[Hz])/(1+(10^(4.57)*ec.freq/1[Hz])^2)+0.0629*(10^(5.16)*ec.freq/1[Hz])/(1+(10^(5.16)*ec.freq/1[Hz])^2)+0.217*(10^(5.74)*ec.freq/1[Hz])/(1+(10^(5.74)*ec.freq/1[Hz])^2)+-0.557*(10^(6.32)*ec.freq/1[Hz])/(1+(10^(6.32)*ec.freq/1[Hz])^2)");
    model.variable("var1")
         .set("epint", "+0.132*DS1/(1+(10^(-5.9)*TS1*ec.freq/1[Hz])^2)+0.0643*DS1/(1+(10^(-5.32)*TS1*ec.freq/1[Hz])^2)+0.103*DS1/(1+(10^(-4.74)*TS1*ec.freq/1[Hz])^2)+0.0895*DS1/(1+(10^(-4.15)*TS1*ec.freq/1[Hz])^2)+0.0864*DS1/(1+(10^(-3.57)*TS1*ec.freq/1[Hz])^2)+0.066*DS1/(1+(10^(-2.99)*TS1*ec.freq/1[Hz])^2)+0.0299*DS1/(1+(10^(-2.41)*TS1*ec.freq/1[Hz])^2)+0.025*DS1/(1+(10^(-1.83)*TS1*ec.freq/1[Hz])^2)+0.0303*DS1/(1+(10^(-1.24)*TS1*ec.freq/1[Hz])^2)+0.0243*DS1/(1+(10^(-0.664)*TS1*ec.freq/1[Hz])^2)+0.0225*DS1/(1+(10^(-0.0809)*TS1*ec.freq/1[Hz])^2)+0.0231*DS2/(1+(10^(0.501)*TS2*ec.freq/1[Hz])^2)+0.0229*DS2/(1+(10^(1.08)*TS2*ec.freq/1[Hz])^2)+0.0207*DS2/(1+(10^(1.66)*TS2*ec.freq/1[Hz])^2)+0.0418*DS2/(1+(10^(2.25)*TS2*ec.freq/1[Hz])^2)+-0.0184*DS2/(1+(10^(2.83)*TS2*ec.freq/1[Hz])^2)+0.185*DS2/(1+(10^(3.41)*TS2*ec.freq/1[Hz])^2)+0.149*DS2/(1+(10^(3.99)*TS2*ec.freq/1[Hz])^2)+0.549*DS2/(1+(10^(4.57)*TS2*ec.freq/1[Hz])^2)+0.0629*DS2/(1+(10^(5.16)*TS2*ec.freq/1[Hz])^2)+0.217*DS2/(1+(10^(5.74)*TS2*ec.freq/1[Hz])^2)+-0.557*DS2/(1+(10^(6.32)*TS2*ec.freq/1[Hz])^2)+3.1+const");
    model.variable("var1")
         .set("eppint", "+0.132*DS1*(10^(-5.9)*TS1*ec.freq/1[Hz])/(1+(10^(-5.9)*TS1*ec.freq/1[Hz])^2)+0.0643*DS1*(10^(-5.32)*TS1*ec.freq/1[Hz])/(1+(10^(-5.32)*TS1*ec.freq/1[Hz])^2)+0.103*DS1*(10^(-4.74)*TS1*ec.freq/1[Hz])/(1+(10^(-4.74)*TS1*ec.freq/1[Hz])^2)+0.0895*DS1*(10^(-4.15)*TS1*ec.freq/1[Hz])/(1+(10^(-4.15)*TS1*ec.freq/1[Hz])^2)+0.0864*DS1*(10^(-3.57)*TS1*ec.freq/1[Hz])/(1+(10^(-3.57)*TS1*ec.freq/1[Hz])^2)+0.066*DS1*(10^(-2.99)*TS1*ec.freq/1[Hz])/(1+(10^(-2.99)*TS1*ec.freq/1[Hz])^2)+0.0299*DS1*(10^(-2.41)*TS1*ec.freq/1[Hz])/(1+(10^(-2.41)*TS1*ec.freq/1[Hz])^2)+0.025*DS1*(10^(-1.83)*TS1*ec.freq/1[Hz])/(1+(10^(-1.83)*TS1*ec.freq/1[Hz])^2)+0.0303*DS1*(10^(-1.24)*TS1*ec.freq/1[Hz])/(1+(10^(-1.24)*TS1*ec.freq/1[Hz])^2)+0.0243*DS1*(10^(-0.664)*TS1*ec.freq/1[Hz])/(1+(10^(-0.664)*TS1*ec.freq/1[Hz])^2)+0.0225*DS1*(10^(-0.0809)*TS1*ec.freq/1[Hz])/(1+(10^(-0.0809)*TS1*ec.freq/1[Hz])^2)+0.0231*DS2*(10^(0.501)*TS2*ec.freq/1[Hz])/(1+(10^(0.501)*TS2*ec.freq/1[Hz])^2)+0.0229*DS2*(10^(1.08)*TS2*ec.freq/1[Hz])/(1+(10^(1.08)*TS2*ec.freq/1[Hz])^2)+0.0207*DS2*(10^(1.66)*TS2*ec.freq/1[Hz])/(1+(10^(1.66)*TS2*ec.freq/1[Hz])^2)+0.0418*DS2*(10^(2.25)*TS2*ec.freq/1[Hz])/(1+(10^(2.25)*TS2*ec.freq/1[Hz])^2)+-0.0184*DS2*(10^(2.83)*TS2*ec.freq/1[Hz])/(1+(10^(2.83)*TS2*ec.freq/1[Hz])^2)+0.185*DS2*(10^(3.41)*TS2*ec.freq/1[Hz])/(1+(10^(3.41)*TS2*ec.freq/1[Hz])^2)+0.149*DS2*(10^(3.99)*TS2*ec.freq/1[Hz])/(1+(10^(3.99)*TS2*ec.freq/1[Hz])^2)+0.549*DS2*(10^(4.57)*TS2*ec.freq/1[Hz])/(1+(10^(4.57)*TS2*ec.freq/1[Hz])^2)+0.0629*DS2*(10^(5.16)*TS2*ec.freq/1[Hz])/(1+(10^(5.16)*TS2*ec.freq/1[Hz])^2)+0.217*DS2*(10^(5.74)*TS2*ec.freq/1[Hz])/(1+(10^(5.74)*TS2*ec.freq/1[Hz])^2)+-0.557*DS2*(10^(6.32)*TS2*ec.freq/1[Hz])/(1+(10^(6.32)*TS2*ec.freq/1[Hz])^2)");

    model.geom("geom1").feature().create("Ellipse1", "Ellipse");
    model.geom("geom1").feature("Ellipse1")
         .set("pos", new double[]{1.1419607843137254E-4, 7.257254901960784E-4});
    model.geom("geom1").feature("Ellipse1")
         .set("semiaxes", new double[]{1.0725736629631103E-5, 4.224108488480569E-6});
    model.geom("geom1").feature("Ellipse1").set("rot", -26.564989056577893);
    model.geom("geom1").feature("Ellipse1").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse2", "Ellipse");
    model.geom("geom1").feature("Ellipse2")
         .set("pos", new double[]{1.3652861952861953E-4, 8.153434343434342E-4});
    model.geom("geom1").feature("Ellipse2")
         .set("semiaxes", new double[]{1.0077010332885703E-5, 5.467875955521641E-6});
    model.geom("geom1").feature("Ellipse2").set("rot", -7.594625609053133);
    model.geom("geom1").feature("Ellipse2").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse3", "Ellipse");
    model.geom("geom1").feature("Ellipse3")
         .set("pos", new double[]{1.5158536585365852E-4, 8.335365853658535E-4});
    model.geom("geom1").feature("Ellipse3")
         .set("semiaxes", new double[]{1.1539848710878798E-5, 4.370147152164384E-6});
    model.geom("geom1").feature("Ellipse3").set("rot", 83.65961262152412);
    model.geom("geom1").feature("Ellipse3").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse4", "Ellipse");
    model.geom("geom1").feature("Ellipse4")
         .set("pos", new double[]{1.5407070707070707E-4, 5.525757575757576E-4});
    model.geom("geom1").feature("Ellipse4")
         .set("semiaxes", new double[]{6.533425672440256E-6, 5.463705515017742E-6});
    model.geom("geom1").feature("Ellipse4").set("rot", 5.710579783680025);
    model.geom("geom1").feature("Ellipse4").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse5", "Ellipse");
    model.geom("geom1").feature("Ellipse5")
         .set("pos", new double[]{1.8502597402597404E-4, 1.753116883116883E-4});
    model.geom("geom1").feature("Ellipse5")
         .set("semiaxes", new double[]{1.0532642274105372E-5, 7.944960787236822E-6});
    model.geom("geom1").feature("Ellipse5").set("rot", -70.55980017231772);
    model.geom("geom1").feature("Ellipse5").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse6", "Ellipse");
    model.geom("geom1").feature("Ellipse6")
         .set("pos", new double[]{1.8476140350877192E-4, 4.85140350877193E-4});
    model.geom("geom1").feature("Ellipse6")
         .set("semiaxes", new double[]{1.0020783054192986E-5, 5.411345071872127E-6});
    model.geom("geom1").feature("Ellipse6").set("rot", 31.60742833433233);
    model.geom("geom1").feature("Ellipse6").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse7", "Ellipse");
    model.geom("geom1").feature("Ellipse7")
         .set("pos", new double[]{2.0298639455782312E-4, 1.548095238095238E-4});
    model.geom("geom1").feature("Ellipse7")
         .set("semiaxes", new double[]{1.2396720277356963E-5, 7.086905208231837E-6});
    model.geom("geom1").feature("Ellipse7").set("rot", -64.98295456348484);
    model.geom("geom1").feature("Ellipse7").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse8", "Ellipse");
    model.geom("geom1").feature("Ellipse8")
         .set("pos", new double[]{2.03238683127572E-4, 3.493292181069959E-4});
    model.geom("geom1").feature("Ellipse8")
         .set("semiaxes", new double[]{6.9485498538961074E-6, 6.211175006115281E-6});
    model.geom("geom1").feature("Ellipse8").set("rot", 29.054536156932983);
    model.geom("geom1").feature("Ellipse8").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse9", "Ellipse");
    model.geom("geom1").feature("Ellipse9")
         .set("pos", new double[]{2.125151515151515E-4, 2.0352813852813853E-4});
    model.geom("geom1").feature("Ellipse9")
         .set("semiaxes", new double[]{6.806346837556748E-6, 6.440031662997993E-6});
    model.geom("geom1").feature("Ellipse9").set("rot", -70.01672974852882);
    model.geom("geom1").feature("Ellipse9").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse10", "Ellipse");
    model.geom("geom1").feature("Ellipse10")
         .set("pos", new double[]{2.2186075949367088E-4, 8.58350210970464E-4});
    model.geom("geom1").feature("Ellipse10")
         .set("semiaxes", new double[]{6.972387626389882E-6, 6.281822885419678E-6});
    model.geom("geom1").feature("Ellipse10").set("rot", -37.87489508311804);
    model.geom("geom1").feature("Ellipse10").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse11", "Ellipse");
    model.geom("geom1").feature("Ellipse11")
         .set("pos", new double[]{2.4564468864468863E-4, 5.791978021978022E-4});
    model.geom("geom1").feature("Ellipse11")
         .set("semiaxes", new double[]{8.693575110267245E-6, 5.6318879236129255E-6});
    model.geom("geom1").feature("Ellipse11").set("rot", 72.8971005658165);
    model.geom("geom1").feature("Ellipse11").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse12", "Ellipse");
    model.geom("geom1").feature("Ellipse12")
         .set("pos", new double[]{2.501481481481481E-4, 8.462222222222221E-4});
    model.geom("geom1").feature("Ellipse12")
         .set("semiaxes", new double[]{7.552445343598368E-6, 5.8618079680082734E-6});
    model.geom("geom1").feature("Ellipse12").set("rot", 22.619812053080302);
    model.geom("geom1").feature("Ellipse12").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse13", "Ellipse");
    model.geom("geom1").feature("Ellipse13")
         .set("pos", new double[]{2.971278538812785E-4, 7.729634703196346E-4});
    model.geom("geom1").feature("Ellipse13")
         .set("semiaxes", new double[]{7.23775504334704E-6, 6.205119709317129E-6});
    model.geom("geom1").feature("Ellipse13").set("rot", -37.87489508311804);
    model.geom("geom1").feature("Ellipse13").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse14", "Ellipse");
    model.geom("geom1").feature("Ellipse14")
         .set("pos", new double[]{2.960845771144278E-4, 5.950696517412935E-4});
    model.geom("geom1").feature("Ellipse14")
         .set("semiaxes", new double[]{9.687193070467668E-6, 4.587190864333574E-6});
    model.geom("geom1").feature("Ellipse14").set("rot", 82.4051639322893);
    model.geom("geom1").feature("Ellipse14").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse15", "Ellipse");
    model.geom("geom1").feature("Ellipse15")
         .set("pos", new double[]{2.982525252525252E-4, 4.495858585858585E-4});
    model.geom("geom1").feature("Ellipse15")
         .set("semiaxes", new double[]{7.10237023515941E-6, 5.016709115919947E-6});
    model.geom("geom1").feature("Ellipse15").set("rot", -16.6992051839878);
    model.geom("geom1").feature("Ellipse15").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse16", "Ellipse");
    model.geom("geom1").feature("Ellipse16")
         .set("pos", new double[]{3.111714285714285E-4, 7.462698412698412E-4});
    model.geom("geom1").feature("Ellipse16")
         .set("semiaxes", new double[]{1.3264975839069002E-5, 4.9323387252461655E-6});
    model.geom("geom1").feature("Ellipse16").set("rot", -75.2562611816544);
    model.geom("geom1").feature("Ellipse16").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse17", "Ellipse");
    model.geom("geom1").feature("Ellipse17")
         .set("pos", new double[]{3.207843137254902E-4, 6.307254901960783E-4});
    model.geom("geom1").feature("Ellipse17")
         .set("semiaxes", new double[]{7.5507213878092605E-6, 5.622260308649912E-6});
    model.geom("geom1").feature("Ellipse17").set("rot", -37.87489508311804);
    model.geom("geom1").feature("Ellipse17").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse18", "Ellipse");
    model.geom("geom1").feature("Ellipse18")
         .set("pos", new double[]{3.258455284552845E-4, 6.749186991869918E-4});
    model.geom("geom1").feature("Ellipse18")
         .set("semiaxes", new double[]{1.2530963840237129E-5, 5.084473625835552E-6});
    model.geom("geom1").feature("Ellipse18").set("rot", -47.29049945687959);
    model.geom("geom1").feature("Ellipse18").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse19", "Ellipse");
    model.geom("geom1").feature("Ellipse19")
         .set("pos", new double[]{3.3124761904761906E-4, 1.9922857142857142E-4});
    model.geom("geom1").feature("Ellipse19")
         .set("semiaxes", new double[]{7.459782600137551E-6, 6.5579170578212136E-6});
    model.geom("geom1").feature("Ellipse19").set("rot", -59.74342313035926);
    model.geom("geom1").feature("Ellipse19").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse20", "Ellipse");
    model.geom("geom1").feature("Ellipse20")
         .set("pos", new double[]{3.5393150684931505E-4, 2.630456621004566E-4});
    model.geom("geom1").feature("Ellipse20")
         .set("semiaxes", new double[]{1.1143846043288197E-5, 5.421858769728834E-6});
    model.geom("geom1").feature("Ellipse20").set("rot", -55.30471714227998);
    model.geom("geom1").feature("Ellipse20").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse21", "Ellipse");
    model.geom("geom1").feature("Ellipse21")
         .set("pos", new double[]{3.6023937360178974E-4, 2.034250559284116E-4});
    model.geom("geom1").feature("Ellipse21")
         .set("semiaxes", new double[]{1.599270366107316E-5, 6.700179663989579E-6});
    model.geom("geom1").feature("Ellipse21").set("rot", 52.12489445822439);
    model.geom("geom1").feature("Ellipse21").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse22", "Ellipse");
    model.geom("geom1").feature("Ellipse22")
         .set("pos", new double[]{3.69859649122807E-4, 1.6289473684210525E-4});
    model.geom("geom1").feature("Ellipse22")
         .set("semiaxes", new double[]{8.477144236030772E-6, 5.001570425590937E-6});
    model.geom("geom1").feature("Ellipse22").set("rot", 77.00520313642154);
    model.geom("geom1").feature("Ellipse22").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse23", "Ellipse");
    model.geom("geom1").feature("Ellipse23")
         .set("pos", new double[]{3.7199999999999993E-4, 2.739523809523809E-4});
    model.geom("geom1").feature("Ellipse23")
         .set("semiaxes", new double[]{9.050321392766792E-6, 5.408360488938921E-6});
    model.geom("geom1").feature("Ellipse23").set("rot", -77.00520313642154);
    model.geom("geom1").feature("Ellipse23").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse24", "Ellipse");
    model.geom("geom1").feature("Ellipse24")
         .set("pos", new double[]{3.8697260273972594E-4, 3.9122831050228304E-4});
    model.geom("geom1").feature("Ellipse24")
         .set("semiaxes", new double[]{8.037084417468261E-6, 5.005421138666082E-6});
    model.geom("geom1").feature("Ellipse24").set("rot", 48.012675229663294);
    model.geom("geom1").feature("Ellipse24").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse25", "Ellipse");
    model.geom("geom1").feature("Ellipse25")
         .set("pos", new double[]{3.9506763285024153E-4, 6.270676328502415E-4});
    model.geom("geom1").feature("Ellipse25")
         .set("semiaxes", new double[]{7.342145213701961E-6, 5.5747674736651975E-6});
    model.geom("geom1").feature("Ellipse25").set("rot", -33.689988744131064);
    model.geom("geom1").feature("Ellipse25").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse26", "Ellipse");
    model.geom("geom1").feature("Ellipse26")
         .set("pos", new double[]{4.116883468834688E-4, 1.9969918699186992E-4});
    model.geom("geom1").feature("Ellipse26")
         .set("semiaxes", new double[]{1.8857666600270055E-5, 6.294449829777256E-6});
    model.geom("geom1").feature("Ellipse26").set("rot", 25.559905401646503);
    model.geom("geom1").feature("Ellipse26").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse27", "Ellipse");
    model.geom("geom1").feature("Ellipse27")
         .set("pos", new double[]{4.0908421052631577E-4, 6.52536842105263E-4});
    model.geom("geom1").feature("Ellipse27")
         .set("semiaxes", new double[]{1.4675981055485553E-5, 6.642025109156799E-6});
    model.geom("geom1").feature("Ellipse27").set("rot", 42.878803334044214);
    model.geom("geom1").feature("Ellipse27").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse28", "Ellipse");
    model.geom("geom1").feature("Ellipse28")
         .set("pos", new double[]{4.1162626262626254E-4, 5.144747474747475E-4});
    model.geom("geom1").feature("Ellipse28")
         .set("semiaxes", new double[]{6.727719356306169E-6, 5.599100045169044E-6});
    model.geom("geom1").feature("Ellipse28").set("rot", 10.304822371608763);
    model.geom("geom1").feature("Ellipse28").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse29", "Ellipse");
    model.geom("geom1").feature("Ellipse29")
         .set("pos", new double[]{4.146769759450172E-4, 6.332061855670102E-4});
    model.geom("geom1").feature("Ellipse29")
         .set("semiaxes", new double[]{8.522901650645484E-6, 6.129480945483211E-6});
    model.geom("geom1").feature("Ellipse29").set("rot", -8.746141810271114);
    model.geom("geom1").feature("Ellipse29").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse30", "Ellipse");
    model.geom("geom1").feature("Ellipse30")
         .set("pos", new double[]{4.2450750750750745E-4, 2.443033033033033E-4});
    model.geom("geom1").feature("Ellipse30")
         .set("semiaxes", new double[]{8.162444780531076E-6, 7.723639290432988E-6});
    model.geom("geom1").feature("Ellipse30").set("rot", 28.610392762421508);
    model.geom("geom1").feature("Ellipse30").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse31", "Ellipse");
    model.geom("geom1").feature("Ellipse31")
         .set("pos", new double[]{4.2769999999999993E-4, 1.65E-4});
    model.geom("geom1").feature("Ellipse31")
         .set("semiaxes", new double[]{9.299460242493617E-6, 5.7609450560054025E-6});
    model.geom("geom1").feature("Ellipse31").set("rot", 59.74342313035926);
    model.geom("geom1").feature("Ellipse31").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse32", "Ellipse");
    model.geom("geom1").feature("Ellipse32")
         .set("pos", new double[]{4.439783549783549E-4, 6.893463203463203E-4});
    model.geom("geom1").feature("Ellipse32")
         .set("semiaxes", new double[]{9.533882512466591E-6, 4.689012459118407E-6});
    model.geom("geom1").feature("Ellipse32").set("rot", 11.309906026540151);
    model.geom("geom1").feature("Ellipse32").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse33", "Ellipse");
    model.geom("geom1").feature("Ellipse33")
         .set("pos", new double[]{4.7120202020202017E-4, 3.005757575757575E-4});
    model.geom("geom1").feature("Ellipse33")
         .set("semiaxes", new double[]{8.345038713187015E-6, 5.358360441712026E-6});
    model.geom("geom1").feature("Ellipse33").set("rot", 75.96357889618216);
    model.geom("geom1").feature("Ellipse33").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse34", "Ellipse");
    model.geom("geom1").feature("Ellipse34")
         .set("pos", new double[]{4.7546808510638293E-4, 7.292695035460992E-4});
    model.geom("geom1").feature("Ellipse34")
         .set("semiaxes", new double[]{1.4498430446293739E-5, 6.749116198185238E-6});
    model.geom("geom1").feature("Ellipse34").set("rot", 62.10258374619715);
    model.geom("geom1").feature("Ellipse34").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse35", "Ellipse");
    model.geom("geom1").feature("Ellipse35")
         .set("pos", new double[]{4.777794871794872E-4, 2.400974358974359E-4});
    model.geom("geom1").feature("Ellipse35")
         .set("semiaxes", new double[]{6.389178316861262E-6, 5.7043977813816E-6});
    model.geom("geom1").feature("Ellipse35").set("rot", 44.99989477067122);
    model.geom("geom1").feature("Ellipse35").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse36", "Ellipse");
    model.geom("geom1").feature("Ellipse36")
         .set("pos", new double[]{5.035656565656565E-4, 5.130808080808081E-4});
    model.geom("geom1").feature("Ellipse36")
         .set("semiaxes", new double[]{7.179446953243468E-6, 5.0085474149967204E-6});
    model.geom("geom1").feature("Ellipse36").set("rot", -10.304822371608763);
    model.geom("geom1").feature("Ellipse36").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse37", "Ellipse");
    model.geom("geom1").feature("Ellipse37")
         .set("pos", new double[]{5.103559322033898E-4, 4.354406779661017E-4});
    model.geom("geom1").feature("Ellipse37")
         .set("semiaxes", new double[]{9.20674717382797E-6, 7.015240045483094E-6});
    model.geom("geom1").feature("Ellipse37").set("rot", -77.90506074706742);
    model.geom("geom1").feature("Ellipse37").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse38", "Ellipse");
    model.geom("geom1").feature("Ellipse38")
         .set("pos", new double[]{5.255833333333333E-4, 1.0895833333333333E-4});
    model.geom("geom1").feature("Ellipse38")
         .set("semiaxes", new double[]{7.405820213728592E-6, 5.601341875157883E-6});
    model.geom("geom1").feature("Ellipse38").set("rot", 15.255083030037738);
    model.geom("geom1").feature("Ellipse38").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse39", "Ellipse");
    model.geom("geom1").feature("Ellipse39")
         .set("pos", new double[]{5.446894977168949E-4, 1.2227853881278537E-4});
    model.geom("geom1").feature("Ellipse39")
         .set("semiaxes", new double[]{9.58040805769425E-6, 5.020707054787304E-6});
    model.geom("geom1").feature("Ellipse39").set("rot", 63.434800484764544);
    model.geom("geom1").feature("Ellipse39").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse40", "Ellipse");
    model.geom("geom1").feature("Ellipse40")
         .set("pos", new double[]{5.706245210727968E-4, 1.5344444444444444E-4});
    model.geom("geom1").feature("Ellipse40")
         .set("semiaxes", new double[]{1.4737374937987397E-5, 4.6737612493968286E-6});
    model.geom("geom1").feature("Ellipse40").set("rot", 86.98700908235035);
    model.geom("geom1").feature("Ellipse40").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse41", "Ellipse");
    model.geom("geom1").feature("Ellipse41")
         .set("pos", new double[]{5.727695473251028E-4, 2.755843621399177E-4});
    model.geom("geom1").feature("Ellipse41")
         .set("semiaxes", new double[]{7.530238568233384E-6, 6.721785462400201E-6});
    model.geom("geom1").feature("Ellipse41").set("rot", -85.6010944724094);
    model.geom("geom1").feature("Ellipse41").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse42", "Ellipse");
    model.geom("geom1").feature("Ellipse42")
         .set("pos", new double[]{5.902761904761904E-4, 5.478761904761904E-4});
    model.geom("geom1").feature("Ellipse42")
         .set("semiaxes", new double[]{1.060093510027216E-5, 5.560768088467088E-6});
    model.geom("geom1").feature("Ellipse42").set("rot", 58.392361207010104);
    model.geom("geom1").feature("Ellipse42").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse43", "Ellipse");
    model.geom("geom1").feature("Ellipse43")
         .set("pos", new double[]{6.05247619047619E-4, 7.353999999999999E-4});
    model.geom("geom1").feature("Ellipse43")
         .set("semiaxes", new double[]{6.703060076767801E-6, 5.620615414432847E-6});
    model.geom("geom1").feature("Ellipse43").set("rot", 36.86981142818665);
    model.geom("geom1").feature("Ellipse43").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse44", "Ellipse");
    model.geom("geom1").feature("Ellipse44")
         .set("pos", new double[]{6.553722943722943E-4, 2.5279220779220776E-4});
    model.geom("geom1").feature("Ellipse44")
         .set("semiaxes", new double[]{1.188664262694134E-5, 4.605365288142908E-6});
    model.geom("geom1").feature("Ellipse44").set("rot", -42.51034767031613);
    model.geom("geom1").feature("Ellipse44").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse45", "Ellipse");
    model.geom("geom1").feature("Ellipse45")
         .set("pos", new double[]{6.557417840375586E-4, 2.9756338028169013E-4});
    model.geom("geom1").feature("Ellipse45")
         .set("semiaxes", new double[]{6.425856195174745E-6, 6.189479484256999E-6});
    model.geom("geom1").feature("Ellipse45").set("rot", 5.194416760928864);
    model.geom("geom1").feature("Ellipse45").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse46", "Ellipse");
    model.geom("geom1").feature("Ellipse46")
         .set("pos", new double[]{6.768156028368794E-4, 5.391843971631206E-4});
    model.geom("geom1").feature("Ellipse46")
         .set("semiaxes", new double[]{1.041435111257454E-5, 4.995539204660535E-6});
    model.geom("geom1").feature("Ellipse46").set("rot", -11.309906026540151);
    model.geom("geom1").feature("Ellipse46").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse47", "Ellipse");
    model.geom("geom1").feature("Ellipse47")
         .set("pos", new double[]{6.865342465753424E-4, 5.602876712328766E-4});
    model.geom("geom1").feature("Ellipse47")
         .set("semiaxes", new double[]{7.29045990776208E-6, 5.495683158476657E-6});
    model.geom("geom1").feature("Ellipse47").set("rot", 5.194416760928864);
    model.geom("geom1").feature("Ellipse47").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse48", "Ellipse");
    model.geom("geom1").feature("Ellipse48")
         .set("pos", new double[]{7.063974358974358E-4, 4.452435897435897E-4});
    model.geom("geom1").feature("Ellipse48")
         .set("semiaxes", new double[]{1.376764573496586E-5, 4.672043169412252E-6});
    model.geom("geom1").feature("Ellipse48").set("rot", 75.2562611816544);
    model.geom("geom1").feature("Ellipse48").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse49", "Ellipse");
    model.geom("geom1").feature("Ellipse49")
         .set("pos", new double[]{7.394600938967136E-4, 4.714788732394366E-4});
    model.geom("geom1").feature("Ellipse49")
         .set("semiaxes", new double[]{6.9502699500325835E-6, 6.070501602579367E-6});
    model.geom("geom1").feature("Ellipse49").set("rot", -63.434800484764544);
    model.geom("geom1").feature("Ellipse49").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse50", "Ellipse");
    model.geom("geom1").feature("Ellipse50")
         .set("pos", new double[]{7.86353846153846E-4, 6.724461538461537E-4});
    model.geom("geom1").feature("Ellipse50")
         .set("semiaxes", new double[]{7.1333321191362835E-6, 5.379919456874247E-6});
    model.geom("geom1").feature("Ellipse50").set("rot", 44.99989477067122);
    model.geom("geom1").feature("Ellipse50").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse51", "Ellipse");
    model.geom("geom1").feature("Ellipse51")
         .set("pos", new double[]{7.985624999999999E-4, 8.062499999999999E-4});
    model.geom("geom1").feature("Ellipse51")
         .set("semiaxes", new double[]{7.423833760039371E-6, 4.828866294333344E-6});
    model.geom("geom1").feature("Ellipse51").set("rot", 37.87489508311804);
    model.geom("geom1").feature("Ellipse51").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse52", "Ellipse");
    model.geom("geom1").feature("Ellipse52")
         .set("pos", new double[]{8.048461538461537E-4, 1.654273504273504E-4});
    model.geom("geom1").feature("Ellipse52")
         .set("semiaxes", new double[]{9.762626475414863E-6, 4.7425335408578555E-6});
    model.geom("geom1").feature("Ellipse52").set("rot", 82.4051639322893);
    model.geom("geom1").feature("Ellipse52").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse53", "Ellipse");
    model.geom("geom1").feature("Ellipse53")
         .set("pos", new double[]{8.189374999999999E-4, 5.244999999999999E-4});
    model.geom("geom1").feature("Ellipse53")
         .set("semiaxes", new double[]{6.995967183843656E-6, 5.448898005399543E-6});
    model.geom("geom1").feature("Ellipse53").set("rot", -5.194416760928864);
    model.geom("geom1").feature("Ellipse53").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse54", "Ellipse");
    model.geom("geom1").feature("Ellipse54")
         .set("pos", new double[]{8.214235294117647E-4, 1.2487450980392157E-4});
    model.geom("geom1").feature("Ellipse54")
         .set("semiaxes", new double[]{9.33885377841842E-6, 5.935424787579452E-6});
    model.geom("geom1").feature("Ellipse54").set("rot", 85.91418231529447);
    model.geom("geom1").feature("Ellipse54").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse55", "Ellipse");
    model.geom("geom1").feature("Ellipse55")
         .set("pos", new double[]{8.362912912912912E-4, 2.2346246246246243E-4});
    model.geom("geom1").feature("Ellipse55")
         .set("semiaxes", new double[]{9.201743720866256E-6, 7.669693189257516E-6});
    model.geom("geom1").feature("Ellipse55").set("rot", 50.194311531600086);
    model.geom("geom1").feature("Ellipse55").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse56", "Ellipse");
    model.geom("geom1").feature("Ellipse56")
         .set("pos", new double[]{8.469499999999999E-4, 4.940166666666666E-4});
    model.geom("geom1").feature("Ellipse56")
         .set("semiaxes", new double[]{7.4408194219163355E-6, 6.526726314412374E-6});
    model.geom("geom1").feature("Ellipse56").set("rot", -4.398695068933043);
    model.geom("geom1").feature("Ellipse56").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse57", "Ellipse");
    model.geom("geom1").feature("Ellipse57")
         .set("pos", new double[]{8.595208333333332E-4, 3.6020833333333326E-4});
    model.geom("geom1").feature("Ellipse57")
         .set("semiaxes", new double[]{7.6229563316459E-6, 4.561771037968664E-6});
    model.geom("geom1").feature("Ellipse57").set("rot", 70.01672974852882);
    model.geom("geom1").feature("Ellipse57").set("createselection", "on");
    model.geom("geom1").feature().create("Ellipse58", "Ellipse");
    model.geom("geom1").feature("Ellipse58")
         .set("pos", new double[]{8.793966244725738E-4, 8.639535864978902E-4});
    model.geom("geom1").feature("Ellipse58")
         .set("semiaxes", new double[]{7.164956807468761E-6, 5.88968950920745E-6});
    model.geom("geom1").feature("Ellipse58").set("rot", 44.99989477067122);
    model.geom("geom1").feature("Ellipse58").set("createselection", "on");
    model.geom("geom1").runAll();
    model.geom("geom1").feature().create("UnionFiller", "Union");
    model.geom("geom1").feature("UnionFiller").selection("input")
         .set(new String[]{"Ellipse1", "Ellipse2", "Ellipse3", "Ellipse4", "Ellipse5", "Ellipse6", "Ellipse7", "Ellipse8", "Ellipse9", "Ellipse10", "Ellipse11", "Ellipse12", "Ellipse13", "Ellipse14", "Ellipse15", "Ellipse16", "Ellipse17", "Ellipse18", "Ellipse19", "Ellipse20", "Ellipse21", "Ellipse22", "Ellipse23", "Ellipse24", "Ellipse25", "Ellipse26", "Ellipse27", "Ellipse28", "Ellipse29", "Ellipse30", "Ellipse31", "Ellipse32", "Ellipse33", "Ellipse34", "Ellipse35", "Ellipse36", "Ellipse37", "Ellipse38", "Ellipse39", "Ellipse40", "Ellipse41", "Ellipse42", "Ellipse43", "Ellipse44", "Ellipse45", "Ellipse46", "Ellipse47", "Ellipse48", "Ellipse49", "Ellipse50", "Ellipse51", "Ellipse52", "Ellipse53", "Ellipse54", "Ellipse55", "Ellipse56", "Ellipse57", "Ellipse58"});
    model.geom("geom1").feature("UnionFiller").set("createselection", "on");
    model.geom("geom1").feature("UnionFiller").set("intbnd", "off");
    model.geom("geom1").runAll();
    model.geom("geom1").feature().create("EllipseIF11", "Ellipse");
    model.geom("geom1").feature("EllipseIF11")
         .set("pos", new double[]{1.1419607843137254E-4, 7.257254901960784E-4});
    model.geom("geom1").feature("EllipseIF11")
         .set("semiaxes", new double[]{2.07257366296311E-5, 1.4224108488480567E-5});
    model.geom("geom1").feature("EllipseIF11")
         .set("rot", -26.564989056577893);
    model.geom("geom1").feature("EllipseIF11").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF12", "Ellipse");
    model.geom("geom1").feature("EllipseIF12")
         .set("pos", new double[]{1.3652861952861953E-4, 8.153434343434342E-4});
    model.geom("geom1").feature("EllipseIF12")
         .set("semiaxes", new double[]{2.0077010332885702E-5, 1.546787595552164E-5});
    model.geom("geom1").feature("EllipseIF12").set("rot", -7.594625609053133);
    model.geom("geom1").feature("EllipseIF12").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF13", "Ellipse");
    model.geom("geom1").feature("EllipseIF13")
         .set("pos", new double[]{1.5158536585365852E-4, 8.335365853658535E-4});
    model.geom("geom1").feature("EllipseIF13")
         .set("semiaxes", new double[]{2.1539848710878796E-5, 1.4370147152164383E-5});
    model.geom("geom1").feature("EllipseIF13").set("rot", 83.65961262152412);
    model.geom("geom1").feature("EllipseIF13").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF14", "Ellipse");
    model.geom("geom1").feature("EllipseIF14")
         .set("pos", new double[]{1.5407070707070707E-4, 5.525757575757576E-4});
    model.geom("geom1").feature("EllipseIF14")
         .set("semiaxes", new double[]{1.6533425672440255E-5, 1.5463705515017742E-5});
    model.geom("geom1").feature("EllipseIF14").set("rot", 5.710579783680025);
    model.geom("geom1").feature("EllipseIF14").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF15", "Ellipse");
    model.geom("geom1").feature("EllipseIF15")
         .set("pos", new double[]{1.8502597402597404E-4, 1.753116883116883E-4});
    model.geom("geom1").feature("EllipseIF15")
         .set("semiaxes", new double[]{2.0532642274105373E-5, 1.794496078723682E-5});
    model.geom("geom1").feature("EllipseIF15").set("rot", -70.55980017231772);
    model.geom("geom1").feature("EllipseIF15").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF16", "Ellipse");
    model.geom("geom1").feature("EllipseIF16")
         .set("pos", new double[]{1.8476140350877192E-4, 4.85140350877193E-4});
    model.geom("geom1").feature("EllipseIF16")
         .set("semiaxes", new double[]{2.0020783054192985E-5, 1.5411345071872127E-5});
    model.geom("geom1").feature("EllipseIF16").set("rot", 31.60742833433233);
    model.geom("geom1").feature("EllipseIF16").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF17", "Ellipse");
    model.geom("geom1").feature("EllipseIF17")
         .set("pos", new double[]{2.0298639455782312E-4, 1.548095238095238E-4});
    model.geom("geom1").feature("EllipseIF17")
         .set("semiaxes", new double[]{2.2396720277356964E-5, 1.7086905208231836E-5});
    model.geom("geom1").feature("EllipseIF17").set("rot", -64.98295456348484);
    model.geom("geom1").feature("EllipseIF17").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF18", "Ellipse");
    model.geom("geom1").feature("EllipseIF18")
         .set("pos", new double[]{2.03238683127572E-4, 3.493292181069959E-4});
    model.geom("geom1").feature("EllipseIF18")
         .set("semiaxes", new double[]{1.6948549853896106E-5, 1.621117500611528E-5});
    model.geom("geom1").feature("EllipseIF18").set("rot", 29.054536156932983);
    model.geom("geom1").feature("EllipseIF18").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF19", "Ellipse");
    model.geom("geom1").feature("EllipseIF19")
         .set("pos", new double[]{2.125151515151515E-4, 2.0352813852813853E-4});
    model.geom("geom1").feature("EllipseIF19")
         .set("semiaxes", new double[]{1.6806346837556747E-5, 1.6440031662997994E-5});
    model.geom("geom1").feature("EllipseIF19").set("rot", -70.01672974852882);
    model.geom("geom1").feature("EllipseIF19").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF110", "Ellipse");
    model.geom("geom1").feature("EllipseIF110")
         .set("pos", new double[]{2.2186075949367088E-4, 8.58350210970464E-4});
    model.geom("geom1").feature("EllipseIF110")
         .set("semiaxes", new double[]{1.6972387626389882E-5, 1.6281822885419678E-5});
    model.geom("geom1").feature("EllipseIF110")
         .set("rot", -37.87489508311804);
    model.geom("geom1").feature("EllipseIF110").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF111", "Ellipse");
    model.geom("geom1").feature("EllipseIF111")
         .set("pos", new double[]{2.4564468864468863E-4, 5.791978021978022E-4});
    model.geom("geom1").feature("EllipseIF111")
         .set("semiaxes", new double[]{1.8693575110267242E-5, 1.5631887923612925E-5});
    model.geom("geom1").feature("EllipseIF111").set("rot", 72.8971005658165);
    model.geom("geom1").feature("EllipseIF111").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF112", "Ellipse");
    model.geom("geom1").feature("EllipseIF112")
         .set("pos", new double[]{2.501481481481481E-4, 8.462222222222221E-4});
    model.geom("geom1").feature("EllipseIF112")
         .set("semiaxes", new double[]{1.7552445343598367E-5, 1.5861807968008273E-5});
    model.geom("geom1").feature("EllipseIF112")
         .set("rot", 22.619812053080302);
    model.geom("geom1").feature("EllipseIF112").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF113", "Ellipse");
    model.geom("geom1").feature("EllipseIF113")
         .set("pos", new double[]{2.971278538812785E-4, 7.729634703196346E-4});
    model.geom("geom1").feature("EllipseIF113")
         .set("semiaxes", new double[]{1.723775504334704E-5, 1.6205119709317127E-5});
    model.geom("geom1").feature("EllipseIF113")
         .set("rot", -37.87489508311804);
    model.geom("geom1").feature("EllipseIF113").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF114", "Ellipse");
    model.geom("geom1").feature("EllipseIF114")
         .set("pos", new double[]{2.960845771144278E-4, 5.950696517412935E-4});
    model.geom("geom1").feature("EllipseIF114")
         .set("semiaxes", new double[]{1.9687193070467667E-5, 1.4587190864333572E-5});
    model.geom("geom1").feature("EllipseIF114").set("rot", 82.4051639322893);
    model.geom("geom1").feature("EllipseIF114").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF115", "Ellipse");
    model.geom("geom1").feature("EllipseIF115")
         .set("pos", new double[]{2.982525252525252E-4, 4.495858585858585E-4});
    model.geom("geom1").feature("EllipseIF115")
         .set("semiaxes", new double[]{1.7102370235159408E-5, 1.5016709115919946E-5});
    model.geom("geom1").feature("EllipseIF115").set("rot", -16.6992051839878);
    model.geom("geom1").feature("EllipseIF115").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF116", "Ellipse");
    model.geom("geom1").feature("EllipseIF116")
         .set("pos", new double[]{3.111714285714285E-4, 7.462698412698412E-4});
    model.geom("geom1").feature("EllipseIF116")
         .set("semiaxes", new double[]{2.3264975839069E-5, 1.4932338725246164E-5});
    model.geom("geom1").feature("EllipseIF116").set("rot", -75.2562611816544);
    model.geom("geom1").feature("EllipseIF116").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF117", "Ellipse");
    model.geom("geom1").feature("EllipseIF117")
         .set("pos", new double[]{3.207843137254902E-4, 6.307254901960783E-4});
    model.geom("geom1").feature("EllipseIF117")
         .set("semiaxes", new double[]{1.755072138780926E-5, 1.562226030864991E-5});
    model.geom("geom1").feature("EllipseIF117")
         .set("rot", -37.87489508311804);
    model.geom("geom1").feature("EllipseIF117").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF118", "Ellipse");
    model.geom("geom1").feature("EllipseIF118")
         .set("pos", new double[]{3.258455284552845E-4, 6.749186991869918E-4});
    model.geom("geom1").feature("EllipseIF118")
         .set("semiaxes", new double[]{2.2530963840237128E-5, 1.5084473625835552E-5});
    model.geom("geom1").feature("EllipseIF118")
         .set("rot", -47.29049945687959);
    model.geom("geom1").feature("EllipseIF118").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF119", "Ellipse");
    model.geom("geom1").feature("EllipseIF119")
         .set("pos", new double[]{3.3124761904761906E-4, 1.9922857142857142E-4});
    model.geom("geom1").feature("EllipseIF119")
         .set("semiaxes", new double[]{1.745978260013755E-5, 1.6557917057821213E-5});
    model.geom("geom1").feature("EllipseIF119")
         .set("rot", -59.74342313035926);
    model.geom("geom1").feature("EllipseIF119").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF120", "Ellipse");
    model.geom("geom1").feature("EllipseIF120")
         .set("pos", new double[]{3.5393150684931505E-4, 2.630456621004566E-4});
    model.geom("geom1").feature("EllipseIF120")
         .set("semiaxes", new double[]{2.1143846043288196E-5, 1.542185876972883E-5});
    model.geom("geom1").feature("EllipseIF120")
         .set("rot", -55.30471714227998);
    model.geom("geom1").feature("EllipseIF120").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF121", "Ellipse");
    model.geom("geom1").feature("EllipseIF121")
         .set("pos", new double[]{3.6023937360178974E-4, 2.034250559284116E-4});
    model.geom("geom1").feature("EllipseIF121")
         .set("semiaxes", new double[]{2.599270366107316E-5, 1.6700179663989577E-5});
    model.geom("geom1").feature("EllipseIF121").set("rot", 52.12489445822439);
    model.geom("geom1").feature("EllipseIF121").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF122", "Ellipse");
    model.geom("geom1").feature("EllipseIF122")
         .set("pos", new double[]{3.69859649122807E-4, 1.6289473684210525E-4});
    model.geom("geom1").feature("EllipseIF122")
         .set("semiaxes", new double[]{1.8477144236030772E-5, 1.5001570425590935E-5});
    model.geom("geom1").feature("EllipseIF122").set("rot", 77.00520313642154);
    model.geom("geom1").feature("EllipseIF122").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF123", "Ellipse");
    model.geom("geom1").feature("EllipseIF123")
         .set("pos", new double[]{3.7199999999999993E-4, 2.739523809523809E-4});
    model.geom("geom1").feature("EllipseIF123")
         .set("semiaxes", new double[]{1.9050321392766793E-5, 1.540836048893892E-5});
    model.geom("geom1").feature("EllipseIF123")
         .set("rot", -77.00520313642154);
    model.geom("geom1").feature("EllipseIF123").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF124", "Ellipse");
    model.geom("geom1").feature("EllipseIF124")
         .set("pos", new double[]{3.8697260273972594E-4, 3.9122831050228304E-4});
    model.geom("geom1").feature("EllipseIF124")
         .set("semiaxes", new double[]{1.803708441746826E-5, 1.5005421138666081E-5});
    model.geom("geom1").feature("EllipseIF124")
         .set("rot", 48.012675229663294);
    model.geom("geom1").feature("EllipseIF124").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF125", "Ellipse");
    model.geom("geom1").feature("EllipseIF125")
         .set("pos", new double[]{3.9506763285024153E-4, 6.270676328502415E-4});
    model.geom("geom1").feature("EllipseIF125")
         .set("semiaxes", new double[]{1.734214521370196E-5, 1.5574767473665197E-5});
    model.geom("geom1").feature("EllipseIF125")
         .set("rot", -33.689988744131064);
    model.geom("geom1").feature("EllipseIF125").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF126", "Ellipse");
    model.geom("geom1").feature("EllipseIF126")
         .set("pos", new double[]{4.116883468834688E-4, 1.9969918699186992E-4});
    model.geom("geom1").feature("EllipseIF126")
         .set("semiaxes", new double[]{2.8857666600270054E-5, 1.6294449829777255E-5});
    model.geom("geom1").feature("EllipseIF126")
         .set("rot", 25.559905401646503);
    model.geom("geom1").feature("EllipseIF126").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF127", "Ellipse");
    model.geom("geom1").feature("EllipseIF127")
         .set("pos", new double[]{4.0908421052631577E-4, 6.52536842105263E-4});
    model.geom("geom1").feature("EllipseIF127")
         .set("semiaxes", new double[]{2.467598105548555E-5, 1.66420251091568E-5});
    model.geom("geom1").feature("EllipseIF127")
         .set("rot", 42.878803334044214);
    model.geom("geom1").feature("EllipseIF127").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF128", "Ellipse");
    model.geom("geom1").feature("EllipseIF128")
         .set("pos", new double[]{4.1162626262626254E-4, 5.144747474747475E-4});
    model.geom("geom1").feature("EllipseIF128")
         .set("semiaxes", new double[]{1.672771935630617E-5, 1.5599100045169043E-5});
    model.geom("geom1").feature("EllipseIF128")
         .set("rot", 10.304822371608763);
    model.geom("geom1").feature("EllipseIF128").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF129", "Ellipse");
    model.geom("geom1").feature("EllipseIF129")
         .set("pos", new double[]{4.146769759450172E-4, 6.332061855670102E-4});
    model.geom("geom1").feature("EllipseIF129")
         .set("semiaxes", new double[]{1.8522901650645483E-5, 1.612948094548321E-5});
    model.geom("geom1").feature("EllipseIF129")
         .set("rot", -8.746141810271114);
    model.geom("geom1").feature("EllipseIF129").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF130", "Ellipse");
    model.geom("geom1").feature("EllipseIF130")
         .set("pos", new double[]{4.2450750750750745E-4, 2.443033033033033E-4});
    model.geom("geom1").feature("EllipseIF130")
         .set("semiaxes", new double[]{1.8162444780531077E-5, 1.772363929043299E-5});
    model.geom("geom1").feature("EllipseIF130")
         .set("rot", 28.610392762421508);
    model.geom("geom1").feature("EllipseIF130").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF131", "Ellipse");
    model.geom("geom1").feature("EllipseIF131")
         .set("pos", new double[]{4.2769999999999993E-4, 1.65E-4});
    model.geom("geom1").feature("EllipseIF131")
         .set("semiaxes", new double[]{1.9299460242493618E-5, 1.57609450560054E-5});
    model.geom("geom1").feature("EllipseIF131").set("rot", 59.74342313035926);
    model.geom("geom1").feature("EllipseIF131").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF132", "Ellipse");
    model.geom("geom1").feature("EllipseIF132")
         .set("pos", new double[]{4.439783549783549E-4, 6.893463203463203E-4});
    model.geom("geom1").feature("EllipseIF132")
         .set("semiaxes", new double[]{1.9533882512466592E-5, 1.4689012459118406E-5});
    model.geom("geom1").feature("EllipseIF132")
         .set("rot", 11.309906026540151);
    model.geom("geom1").feature("EllipseIF132").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF133", "Ellipse");
    model.geom("geom1").feature("EllipseIF133")
         .set("pos", new double[]{4.7120202020202017E-4, 3.005757575757575E-4});
    model.geom("geom1").feature("EllipseIF133")
         .set("semiaxes", new double[]{1.8345038713187015E-5, 1.5358360441712025E-5});
    model.geom("geom1").feature("EllipseIF133").set("rot", 75.96357889618216);
    model.geom("geom1").feature("EllipseIF133").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF134", "Ellipse");
    model.geom("geom1").feature("EllipseIF134")
         .set("pos", new double[]{4.7546808510638293E-4, 7.292695035460992E-4});
    model.geom("geom1").feature("EllipseIF134")
         .set("semiaxes", new double[]{2.4498430446293736E-5, 1.6749116198185238E-5});
    model.geom("geom1").feature("EllipseIF134").set("rot", 62.10258374619715);
    model.geom("geom1").feature("EllipseIF134").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF135", "Ellipse");
    model.geom("geom1").feature("EllipseIF135")
         .set("pos", new double[]{4.777794871794872E-4, 2.400974358974359E-4});
    model.geom("geom1").feature("EllipseIF135")
         .set("semiaxes", new double[]{1.638917831686126E-5, 1.57043977813816E-5});
    model.geom("geom1").feature("EllipseIF135").set("rot", 44.99989477067122);
    model.geom("geom1").feature("EllipseIF135").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF136", "Ellipse");
    model.geom("geom1").feature("EllipseIF136")
         .set("pos", new double[]{5.035656565656565E-4, 5.130808080808081E-4});
    model.geom("geom1").feature("EllipseIF136")
         .set("semiaxes", new double[]{1.717944695324347E-5, 1.500854741499672E-5});
    model.geom("geom1").feature("EllipseIF136")
         .set("rot", -10.304822371608763);
    model.geom("geom1").feature("EllipseIF136").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF137", "Ellipse");
    model.geom("geom1").feature("EllipseIF137")
         .set("pos", new double[]{5.103559322033898E-4, 4.354406779661017E-4});
    model.geom("geom1").feature("EllipseIF137")
         .set("semiaxes", new double[]{1.9206747173827968E-5, 1.7015240045483093E-5});
    model.geom("geom1").feature("EllipseIF137")
         .set("rot", -77.90506074706742);
    model.geom("geom1").feature("EllipseIF137").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF138", "Ellipse");
    model.geom("geom1").feature("EllipseIF138")
         .set("pos", new double[]{5.255833333333333E-4, 1.0895833333333333E-4});
    model.geom("geom1").feature("EllipseIF138")
         .set("semiaxes", new double[]{1.740582021372859E-5, 1.560134187515788E-5});
    model.geom("geom1").feature("EllipseIF138")
         .set("rot", 15.255083030037738);
    model.geom("geom1").feature("EllipseIF138").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF139", "Ellipse");
    model.geom("geom1").feature("EllipseIF139")
         .set("pos", new double[]{5.446894977168949E-4, 1.2227853881278537E-4});
    model.geom("geom1").feature("EllipseIF139")
         .set("semiaxes", new double[]{1.9580408057694248E-5, 1.5020707054787303E-5});
    model.geom("geom1").feature("EllipseIF139")
         .set("rot", 63.434800484764544);
    model.geom("geom1").feature("EllipseIF139").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF140", "Ellipse");
    model.geom("geom1").feature("EllipseIF140")
         .set("pos", new double[]{5.706245210727968E-4, 1.5344444444444444E-4});
    model.geom("geom1").feature("EllipseIF140")
         .set("semiaxes", new double[]{2.4737374937987396E-5, 1.4673761249396829E-5});
    model.geom("geom1").feature("EllipseIF140").set("rot", 86.98700908235035);
    model.geom("geom1").feature("EllipseIF140").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF141", "Ellipse");
    model.geom("geom1").feature("EllipseIF141")
         .set("pos", new double[]{5.727695473251028E-4, 2.755843621399177E-4});
    model.geom("geom1").feature("EllipseIF141")
         .set("semiaxes", new double[]{1.7530238568233382E-5, 1.67217854624002E-5});
    model.geom("geom1").feature("EllipseIF141").set("rot", -85.6010944724094);
    model.geom("geom1").feature("EllipseIF141").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF142", "Ellipse");
    model.geom("geom1").feature("EllipseIF142")
         .set("pos", new double[]{5.902761904761904E-4, 5.478761904761904E-4});
    model.geom("geom1").feature("EllipseIF142")
         .set("semiaxes", new double[]{2.0600935100272157E-5, 1.5560768088467087E-5});
    model.geom("geom1").feature("EllipseIF142")
         .set("rot", 58.392361207010104);
    model.geom("geom1").feature("EllipseIF142").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF143", "Ellipse");
    model.geom("geom1").feature("EllipseIF143")
         .set("pos", new double[]{6.05247619047619E-4, 7.353999999999999E-4});
    model.geom("geom1").feature("EllipseIF143")
         .set("semiaxes", new double[]{1.67030600767678E-5, 1.5620615414432847E-5});
    model.geom("geom1").feature("EllipseIF143").set("rot", 36.86981142818665);
    model.geom("geom1").feature("EllipseIF143").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF144", "Ellipse");
    model.geom("geom1").feature("EllipseIF144")
         .set("pos", new double[]{6.553722943722943E-4, 2.5279220779220776E-4});
    model.geom("geom1").feature("EllipseIF144")
         .set("semiaxes", new double[]{2.188664262694134E-5, 1.4605365288142907E-5});
    model.geom("geom1").feature("EllipseIF144")
         .set("rot", -42.51034767031613);
    model.geom("geom1").feature("EllipseIF144").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF145", "Ellipse");
    model.geom("geom1").feature("EllipseIF145")
         .set("pos", new double[]{6.557417840375586E-4, 2.9756338028169013E-4});
    model.geom("geom1").feature("EllipseIF145")
         .set("semiaxes", new double[]{1.6425856195174742E-5, 1.6189479484256997E-5});
    model.geom("geom1").feature("EllipseIF145").set("rot", 5.194416760928864);
    model.geom("geom1").feature("EllipseIF145").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF146", "Ellipse");
    model.geom("geom1").feature("EllipseIF146")
         .set("pos", new double[]{6.768156028368794E-4, 5.391843971631206E-4});
    model.geom("geom1").feature("EllipseIF146")
         .set("semiaxes", new double[]{2.041435111257454E-5, 1.4995539204660533E-5});
    model.geom("geom1").feature("EllipseIF146")
         .set("rot", -11.309906026540151);
    model.geom("geom1").feature("EllipseIF146").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF147", "Ellipse");
    model.geom("geom1").feature("EllipseIF147")
         .set("pos", new double[]{6.865342465753424E-4, 5.602876712328766E-4});
    model.geom("geom1").feature("EllipseIF147")
         .set("semiaxes", new double[]{1.729045990776208E-5, 1.5495683158476654E-5});
    model.geom("geom1").feature("EllipseIF147").set("rot", 5.194416760928864);
    model.geom("geom1").feature("EllipseIF147").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF148", "Ellipse");
    model.geom("geom1").feature("EllipseIF148")
         .set("pos", new double[]{7.063974358974358E-4, 4.452435897435897E-4});
    model.geom("geom1").feature("EllipseIF148")
         .set("semiaxes", new double[]{2.376764573496586E-5, 1.4672043169412251E-5});
    model.geom("geom1").feature("EllipseIF148").set("rot", 75.2562611816544);
    model.geom("geom1").feature("EllipseIF148").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF149", "Ellipse");
    model.geom("geom1").feature("EllipseIF149")
         .set("pos", new double[]{7.394600938967136E-4, 4.714788732394366E-4});
    model.geom("geom1").feature("EllipseIF149")
         .set("semiaxes", new double[]{1.6950269950032582E-5, 1.6070501602579365E-5});
    model.geom("geom1").feature("EllipseIF149")
         .set("rot", -63.434800484764544);
    model.geom("geom1").feature("EllipseIF149").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF150", "Ellipse");
    model.geom("geom1").feature("EllipseIF150")
         .set("pos", new double[]{7.86353846153846E-4, 6.724461538461537E-4});
    model.geom("geom1").feature("EllipseIF150")
         .set("semiaxes", new double[]{1.7133332119136283E-5, 1.5379919456874247E-5});
    model.geom("geom1").feature("EllipseIF150").set("rot", 44.99989477067122);
    model.geom("geom1").feature("EllipseIF150").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF151", "Ellipse");
    model.geom("geom1").feature("EllipseIF151")
         .set("pos", new double[]{7.985624999999999E-4, 8.062499999999999E-4});
    model.geom("geom1").feature("EllipseIF151")
         .set("semiaxes", new double[]{1.742383376003937E-5, 1.4828866294333344E-5});
    model.geom("geom1").feature("EllipseIF151").set("rot", 37.87489508311804);
    model.geom("geom1").feature("EllipseIF151").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF152", "Ellipse");
    model.geom("geom1").feature("EllipseIF152")
         .set("pos", new double[]{8.048461538461537E-4, 1.654273504273504E-4});
    model.geom("geom1").feature("EllipseIF152")
         .set("semiaxes", new double[]{1.9762626475414864E-5, 1.4742533540857855E-5});
    model.geom("geom1").feature("EllipseIF152").set("rot", 82.4051639322893);
    model.geom("geom1").feature("EllipseIF152").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF153", "Ellipse");
    model.geom("geom1").feature("EllipseIF153")
         .set("pos", new double[]{8.189374999999999E-4, 5.244999999999999E-4});
    model.geom("geom1").feature("EllipseIF153")
         .set("semiaxes", new double[]{1.6995967183843657E-5, 1.5448898005399542E-5});
    model.geom("geom1").feature("EllipseIF153")
         .set("rot", -5.194416760928864);
    model.geom("geom1").feature("EllipseIF153").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF154", "Ellipse");
    model.geom("geom1").feature("EllipseIF154")
         .set("pos", new double[]{8.214235294117647E-4, 1.2487450980392157E-4});
    model.geom("geom1").feature("EllipseIF154")
         .set("semiaxes", new double[]{1.9338853778418417E-5, 1.593542478757945E-5});
    model.geom("geom1").feature("EllipseIF154").set("rot", 85.91418231529447);
    model.geom("geom1").feature("EllipseIF154").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF155", "Ellipse");
    model.geom("geom1").feature("EllipseIF155")
         .set("pos", new double[]{8.362912912912912E-4, 2.2346246246246243E-4});
    model.geom("geom1").feature("EllipseIF155")
         .set("semiaxes", new double[]{1.9201743720866255E-5, 1.7669693189257517E-5});
    model.geom("geom1").feature("EllipseIF155")
         .set("rot", 50.194311531600086);
    model.geom("geom1").feature("EllipseIF155").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF156", "Ellipse");
    model.geom("geom1").feature("EllipseIF156")
         .set("pos", new double[]{8.469499999999999E-4, 4.940166666666666E-4});
    model.geom("geom1").feature("EllipseIF156")
         .set("semiaxes", new double[]{1.7440819421916336E-5, 1.6526726314412372E-5});
    model.geom("geom1").feature("EllipseIF156")
         .set("rot", -4.398695068933043);
    model.geom("geom1").feature("EllipseIF156").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF157", "Ellipse");
    model.geom("geom1").feature("EllipseIF157")
         .set("pos", new double[]{8.595208333333332E-4, 3.6020833333333326E-4});
    model.geom("geom1").feature("EllipseIF157")
         .set("semiaxes", new double[]{1.7622956331645898E-5, 1.4561771037968663E-5});
    model.geom("geom1").feature("EllipseIF157").set("rot", 70.01672974852882);
    model.geom("geom1").feature("EllipseIF157").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF158", "Ellipse");
    model.geom("geom1").feature("EllipseIF158")
         .set("pos", new double[]{8.793966244725738E-4, 8.639535864978902E-4});
    model.geom("geom1").feature("EllipseIF158")
         .set("semiaxes", new double[]{1.716495680746876E-5, 1.588968950920745E-5});
    model.geom("geom1").feature("EllipseIF158").set("rot", 44.99989477067122);
    model.geom("geom1").feature("EllipseIF158").set("createselection", "on");
    model.geom("geom1").runAll();
    model.geom("geom1").feature().create("UnionLargeEllipse1", "Union");
    model.geom("geom1").feature("UnionLargeEllipse1").selection("input")
         .set(new String[]{"EllipseIF11", "EllipseIF12", "EllipseIF13", "EllipseIF14", "EllipseIF15", "EllipseIF16", "EllipseIF17", "EllipseIF18", "EllipseIF19", "EllipseIF110", "EllipseIF111", "EllipseIF112", "EllipseIF113", "EllipseIF114", "EllipseIF115", "EllipseIF116", "EllipseIF117", "EllipseIF118", "EllipseIF119", "EllipseIF120", "EllipseIF121", "EllipseIF122", "EllipseIF123", "EllipseIF124", "EllipseIF125", "EllipseIF126", "EllipseIF127", "EllipseIF128", "EllipseIF129", "EllipseIF130", "EllipseIF131", "EllipseIF132", "EllipseIF133", "EllipseIF134", "EllipseIF135", "EllipseIF136", "EllipseIF137", "EllipseIF138", "EllipseIF139", "EllipseIF140", "EllipseIF141", "EllipseIF142", "EllipseIF143", "EllipseIF144", "EllipseIF145", "EllipseIF146", "EllipseIF147", "EllipseIF148", "EllipseIF149", "EllipseIF150", "EllipseIF151", "EllipseIF152", "EllipseIF153", "EllipseIF154", "EllipseIF155", "EllipseIF156", "EllipseIF157", "EllipseIF158"});
    model.geom("geom1").feature("UnionLargeEllipse1")
         .set("createselection", "on");
    model.geom("geom1").feature("UnionLargeEllipse1").set("intbnd", "off");
    model.geom("geom1").runAll();
    model.geom("geom1").feature().create("DiffInterface1", "Difference");
    model.geom("geom1").feature("DiffInterface1").selection("input")
         .set(new String[]{"UnionLargeEllipse1"});
    model.geom("geom1").feature("DiffInterface1").selection("input2")
         .set(new String[]{"UnionFiller"});
    model.geom("geom1").feature("DiffInterface1").set("keep", "on");
    model.geom("geom1").feature("DiffInterface1")
         .set("createselection", "on");
    model.geom("geom1").feature("DiffInterface1").set("intbnd", "off");
    model.geom("geom1").runAll();
    model.geom("geom1").feature().create("EllipseIF21", "Ellipse");
    model.geom("geom1").feature("EllipseIF21")
         .set("pos", new double[]{1.1419607843137254E-4, 7.257254901960784E-4});
    model.geom("geom1").feature("EllipseIF21")
         .set("semiaxes", new double[]{7.07257366296311E-5, 6.422410848848056E-5});
    model.geom("geom1").feature("EllipseIF21")
         .set("rot", -26.564989056577893);
    model.geom("geom1").feature("EllipseIF21").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF22", "Ellipse");
    model.geom("geom1").feature("EllipseIF22")
         .set("pos", new double[]{1.3652861952861953E-4, 8.153434343434342E-4});
    model.geom("geom1").feature("EllipseIF22")
         .set("semiaxes", new double[]{7.00770103328857E-5, 6.546787595552163E-5});
    model.geom("geom1").feature("EllipseIF22").set("rot", -7.594625609053133);
    model.geom("geom1").feature("EllipseIF22").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF23", "Ellipse");
    model.geom("geom1").feature("EllipseIF23")
         .set("pos", new double[]{1.5158536585365852E-4, 8.335365853658535E-4});
    model.geom("geom1").feature("EllipseIF23")
         .set("semiaxes", new double[]{7.153984871087879E-5, 6.437014715216438E-5});
    model.geom("geom1").feature("EllipseIF23").set("rot", 83.65961262152412);
    model.geom("geom1").feature("EllipseIF23").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF24", "Ellipse");
    model.geom("geom1").feature("EllipseIF24")
         .set("pos", new double[]{1.5407070707070707E-4, 5.525757575757576E-4});
    model.geom("geom1").feature("EllipseIF24")
         .set("semiaxes", new double[]{6.653342567244024E-5, 6.546370551501774E-5});
    model.geom("geom1").feature("EllipseIF24").set("rot", 5.710579783680025);
    model.geom("geom1").feature("EllipseIF24").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF25", "Ellipse");
    model.geom("geom1").feature("EllipseIF25")
         .set("pos", new double[]{1.8502597402597404E-4, 1.753116883116883E-4});
    model.geom("geom1").feature("EllipseIF25")
         .set("semiaxes", new double[]{7.053264227410537E-5, 6.794496078723681E-5});
    model.geom("geom1").feature("EllipseIF25").set("rot", -70.55980017231772);
    model.geom("geom1").feature("EllipseIF25").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF26", "Ellipse");
    model.geom("geom1").feature("EllipseIF26")
         .set("pos", new double[]{1.8476140350877192E-4, 4.85140350877193E-4});
    model.geom("geom1").feature("EllipseIF26")
         .set("semiaxes", new double[]{7.002078305419298E-5, 6.541134507187212E-5});
    model.geom("geom1").feature("EllipseIF26").set("rot", 31.60742833433233);
    model.geom("geom1").feature("EllipseIF26").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF27", "Ellipse");
    model.geom("geom1").feature("EllipseIF27")
         .set("pos", new double[]{2.0298639455782312E-4, 1.548095238095238E-4});
    model.geom("geom1").feature("EllipseIF27")
         .set("semiaxes", new double[]{7.239672027735695E-5, 6.708690520823183E-5});
    model.geom("geom1").feature("EllipseIF27").set("rot", -64.98295456348484);
    model.geom("geom1").feature("EllipseIF27").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF28", "Ellipse");
    model.geom("geom1").feature("EllipseIF28")
         .set("pos", new double[]{2.03238683127572E-4, 3.493292181069959E-4});
    model.geom("geom1").feature("EllipseIF28")
         .set("semiaxes", new double[]{6.694854985389611E-5, 6.621117500611528E-5});
    model.geom("geom1").feature("EllipseIF28").set("rot", 29.054536156932983);
    model.geom("geom1").feature("EllipseIF28").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF29", "Ellipse");
    model.geom("geom1").feature("EllipseIF29")
         .set("pos", new double[]{2.125151515151515E-4, 2.0352813852813853E-4});
    model.geom("geom1").feature("EllipseIF29")
         .set("semiaxes", new double[]{6.680634683755675E-5, 6.644003166299798E-5});
    model.geom("geom1").feature("EllipseIF29").set("rot", -70.01672974852882);
    model.geom("geom1").feature("EllipseIF29").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF210", "Ellipse");
    model.geom("geom1").feature("EllipseIF210")
         .set("pos", new double[]{2.2186075949367088E-4, 8.58350210970464E-4});
    model.geom("geom1").feature("EllipseIF210")
         .set("semiaxes", new double[]{6.697238762638988E-5, 6.628182288541967E-5});
    model.geom("geom1").feature("EllipseIF210")
         .set("rot", -37.87489508311804);
    model.geom("geom1").feature("EllipseIF210").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF211", "Ellipse");
    model.geom("geom1").feature("EllipseIF211")
         .set("pos", new double[]{2.4564468864468863E-4, 5.791978021978022E-4});
    model.geom("geom1").feature("EllipseIF211")
         .set("semiaxes", new double[]{6.869357511026723E-5, 6.563188792361291E-5});
    model.geom("geom1").feature("EllipseIF211").set("rot", 72.8971005658165);
    model.geom("geom1").feature("EllipseIF211").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF212", "Ellipse");
    model.geom("geom1").feature("EllipseIF212")
         .set("pos", new double[]{2.501481481481481E-4, 8.462222222222221E-4});
    model.geom("geom1").feature("EllipseIF212")
         .set("semiaxes", new double[]{6.755244534359836E-5, 6.586180796800827E-5});
    model.geom("geom1").feature("EllipseIF212")
         .set("rot", 22.619812053080302);
    model.geom("geom1").feature("EllipseIF212").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF213", "Ellipse");
    model.geom("geom1").feature("EllipseIF213")
         .set("pos", new double[]{2.971278538812785E-4, 7.729634703196346E-4});
    model.geom("geom1").feature("EllipseIF213")
         .set("semiaxes", new double[]{6.723775504334704E-5, 6.620511970931712E-5});
    model.geom("geom1").feature("EllipseIF213")
         .set("rot", -37.87489508311804);
    model.geom("geom1").feature("EllipseIF213").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF214", "Ellipse");
    model.geom("geom1").feature("EllipseIF214")
         .set("pos", new double[]{2.960845771144278E-4, 5.950696517412935E-4});
    model.geom("geom1").feature("EllipseIF214")
         .set("semiaxes", new double[]{6.968719307046767E-5, 6.458719086433357E-5});
    model.geom("geom1").feature("EllipseIF214").set("rot", 82.4051639322893);
    model.geom("geom1").feature("EllipseIF214").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF215", "Ellipse");
    model.geom("geom1").feature("EllipseIF215")
         .set("pos", new double[]{2.982525252525252E-4, 4.495858585858585E-4});
    model.geom("geom1").feature("EllipseIF215")
         .set("semiaxes", new double[]{6.710237023515941E-5, 6.501670911591994E-5});
    model.geom("geom1").feature("EllipseIF215").set("rot", -16.6992051839878);
    model.geom("geom1").feature("EllipseIF215").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF216", "Ellipse");
    model.geom("geom1").feature("EllipseIF216")
         .set("pos", new double[]{3.111714285714285E-4, 7.462698412698412E-4});
    model.geom("geom1").feature("EllipseIF216")
         .set("semiaxes", new double[]{7.3264975839069E-5, 6.493233872524616E-5});
    model.geom("geom1").feature("EllipseIF216").set("rot", -75.2562611816544);
    model.geom("geom1").feature("EllipseIF216").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF217", "Ellipse");
    model.geom("geom1").feature("EllipseIF217")
         .set("pos", new double[]{3.207843137254902E-4, 6.307254901960783E-4});
    model.geom("geom1").feature("EllipseIF217")
         .set("semiaxes", new double[]{6.755072138780926E-5, 6.562226030864991E-5});
    model.geom("geom1").feature("EllipseIF217")
         .set("rot", -37.87489508311804);
    model.geom("geom1").feature("EllipseIF217").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF218", "Ellipse");
    model.geom("geom1").feature("EllipseIF218")
         .set("pos", new double[]{3.258455284552845E-4, 6.749186991869918E-4});
    model.geom("geom1").feature("EllipseIF218")
         .set("semiaxes", new double[]{7.253096384023713E-5, 6.508447362583555E-5});
    model.geom("geom1").feature("EllipseIF218")
         .set("rot", -47.29049945687959);
    model.geom("geom1").feature("EllipseIF218").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF219", "Ellipse");
    model.geom("geom1").feature("EllipseIF219")
         .set("pos", new double[]{3.3124761904761906E-4, 1.9922857142857142E-4});
    model.geom("geom1").feature("EllipseIF219")
         .set("semiaxes", new double[]{6.745978260013755E-5, 6.655791705782121E-5});
    model.geom("geom1").feature("EllipseIF219")
         .set("rot", -59.74342313035926);
    model.geom("geom1").feature("EllipseIF219").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF220", "Ellipse");
    model.geom("geom1").feature("EllipseIF220")
         .set("pos", new double[]{3.5393150684931505E-4, 2.630456621004566E-4});
    model.geom("geom1").feature("EllipseIF220")
         .set("semiaxes", new double[]{7.11438460432882E-5, 6.542185876972883E-5});
    model.geom("geom1").feature("EllipseIF220")
         .set("rot", -55.30471714227998);
    model.geom("geom1").feature("EllipseIF220").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF221", "Ellipse");
    model.geom("geom1").feature("EllipseIF221")
         .set("pos", new double[]{3.6023937360178974E-4, 2.034250559284116E-4});
    model.geom("geom1").feature("EllipseIF221")
         .set("semiaxes", new double[]{7.599270366107316E-5, 6.670017966398957E-5});
    model.geom("geom1").feature("EllipseIF221").set("rot", 52.12489445822439);
    model.geom("geom1").feature("EllipseIF221").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF222", "Ellipse");
    model.geom("geom1").feature("EllipseIF222")
         .set("pos", new double[]{3.69859649122807E-4, 1.6289473684210525E-4});
    model.geom("geom1").feature("EllipseIF222")
         .set("semiaxes", new double[]{6.847714423603077E-5, 6.500157042559093E-5});
    model.geom("geom1").feature("EllipseIF222").set("rot", 77.00520313642154);
    model.geom("geom1").feature("EllipseIF222").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF223", "Ellipse");
    model.geom("geom1").feature("EllipseIF223")
         .set("pos", new double[]{3.7199999999999993E-4, 2.739523809523809E-4});
    model.geom("geom1").feature("EllipseIF223")
         .set("semiaxes", new double[]{6.905032139276678E-5, 6.540836048893892E-5});
    model.geom("geom1").feature("EllipseIF223")
         .set("rot", -77.00520313642154);
    model.geom("geom1").feature("EllipseIF223").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF224", "Ellipse");
    model.geom("geom1").feature("EllipseIF224")
         .set("pos", new double[]{3.8697260273972594E-4, 3.9122831050228304E-4});
    model.geom("geom1").feature("EllipseIF224")
         .set("semiaxes", new double[]{6.803708441746825E-5, 6.500542113866607E-5});
    model.geom("geom1").feature("EllipseIF224")
         .set("rot", 48.012675229663294);
    model.geom("geom1").feature("EllipseIF224").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF225", "Ellipse");
    model.geom("geom1").feature("EllipseIF225")
         .set("pos", new double[]{3.9506763285024153E-4, 6.270676328502415E-4});
    model.geom("geom1").feature("EllipseIF225")
         .set("semiaxes", new double[]{6.734214521370195E-5, 6.557476747366519E-5});
    model.geom("geom1").feature("EllipseIF225")
         .set("rot", -33.689988744131064);
    model.geom("geom1").feature("EllipseIF225").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF226", "Ellipse");
    model.geom("geom1").feature("EllipseIF226")
         .set("pos", new double[]{4.116883468834688E-4, 1.9969918699186992E-4});
    model.geom("geom1").feature("EllipseIF226")
         .set("semiaxes", new double[]{7.885766660027005E-5, 6.629444982977725E-5});
    model.geom("geom1").feature("EllipseIF226")
         .set("rot", 25.559905401646503);
    model.geom("geom1").feature("EllipseIF226").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF227", "Ellipse");
    model.geom("geom1").feature("EllipseIF227")
         .set("pos", new double[]{4.0908421052631577E-4, 6.52536842105263E-4});
    model.geom("geom1").feature("EllipseIF227")
         .set("semiaxes", new double[]{7.467598105548555E-5, 6.66420251091568E-5});
    model.geom("geom1").feature("EllipseIF227")
         .set("rot", 42.878803334044214);
    model.geom("geom1").feature("EllipseIF227").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF228", "Ellipse");
    model.geom("geom1").feature("EllipseIF228")
         .set("pos", new double[]{4.1162626262626254E-4, 5.144747474747475E-4});
    model.geom("geom1").feature("EllipseIF228")
         .set("semiaxes", new double[]{6.672771935630617E-5, 6.559910004516904E-5});
    model.geom("geom1").feature("EllipseIF228")
         .set("rot", 10.304822371608763);
    model.geom("geom1").feature("EllipseIF228").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF229", "Ellipse");
    model.geom("geom1").feature("EllipseIF229")
         .set("pos", new double[]{4.146769759450172E-4, 6.332061855670102E-4});
    model.geom("geom1").feature("EllipseIF229")
         .set("semiaxes", new double[]{6.852290165064548E-5, 6.61294809454832E-5});
    model.geom("geom1").feature("EllipseIF229")
         .set("rot", -8.746141810271114);
    model.geom("geom1").feature("EllipseIF229").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF230", "Ellipse");
    model.geom("geom1").feature("EllipseIF230")
         .set("pos", new double[]{4.2450750750750745E-4, 2.443033033033033E-4});
    model.geom("geom1").feature("EllipseIF230")
         .set("semiaxes", new double[]{6.816244478053107E-5, 6.772363929043298E-5});
    model.geom("geom1").feature("EllipseIF230")
         .set("rot", 28.610392762421508);
    model.geom("geom1").feature("EllipseIF230").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF231", "Ellipse");
    model.geom("geom1").feature("EllipseIF231")
         .set("pos", new double[]{4.2769999999999993E-4, 1.65E-4});
    model.geom("geom1").feature("EllipseIF231")
         .set("semiaxes", new double[]{6.929946024249361E-5, 6.57609450560054E-5});
    model.geom("geom1").feature("EllipseIF231").set("rot", 59.74342313035926);
    model.geom("geom1").feature("EllipseIF231").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF232", "Ellipse");
    model.geom("geom1").feature("EllipseIF232")
         .set("pos", new double[]{4.439783549783549E-4, 6.893463203463203E-4});
    model.geom("geom1").feature("EllipseIF232")
         .set("semiaxes", new double[]{6.953388251246659E-5, 6.46890124591184E-5});
    model.geom("geom1").feature("EllipseIF232")
         .set("rot", 11.309906026540151);
    model.geom("geom1").feature("EllipseIF232").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF233", "Ellipse");
    model.geom("geom1").feature("EllipseIF233")
         .set("pos", new double[]{4.7120202020202017E-4, 3.005757575757575E-4});
    model.geom("geom1").feature("EllipseIF233")
         .set("semiaxes", new double[]{6.834503871318702E-5, 6.535836044171202E-5});
    model.geom("geom1").feature("EllipseIF233").set("rot", 75.96357889618216);
    model.geom("geom1").feature("EllipseIF233").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF234", "Ellipse");
    model.geom("geom1").feature("EllipseIF234")
         .set("pos", new double[]{4.7546808510638293E-4, 7.292695035460992E-4});
    model.geom("geom1").feature("EllipseIF234")
         .set("semiaxes", new double[]{7.449843044629373E-5, 6.674911619818524E-5});
    model.geom("geom1").feature("EllipseIF234").set("rot", 62.10258374619715);
    model.geom("geom1").feature("EllipseIF234").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF235", "Ellipse");
    model.geom("geom1").feature("EllipseIF235")
         .set("pos", new double[]{4.777794871794872E-4, 2.400974358974359E-4});
    model.geom("geom1").feature("EllipseIF235")
         .set("semiaxes", new double[]{6.638917831686125E-5, 6.57043977813816E-5});
    model.geom("geom1").feature("EllipseIF235").set("rot", 44.99989477067122);
    model.geom("geom1").feature("EllipseIF235").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF236", "Ellipse");
    model.geom("geom1").feature("EllipseIF236")
         .set("pos", new double[]{5.035656565656565E-4, 5.130808080808081E-4});
    model.geom("geom1").feature("EllipseIF236")
         .set("semiaxes", new double[]{6.717944695324346E-5, 6.500854741499671E-5});
    model.geom("geom1").feature("EllipseIF236")
         .set("rot", -10.304822371608763);
    model.geom("geom1").feature("EllipseIF236").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF237", "Ellipse");
    model.geom("geom1").feature("EllipseIF237")
         .set("pos", new double[]{5.103559322033898E-4, 4.354406779661017E-4});
    model.geom("geom1").feature("EllipseIF237")
         .set("semiaxes", new double[]{6.920674717382796E-5, 6.701524004548309E-5});
    model.geom("geom1").feature("EllipseIF237")
         .set("rot", -77.90506074706742);
    model.geom("geom1").feature("EllipseIF237").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF238", "Ellipse");
    model.geom("geom1").feature("EllipseIF238")
         .set("pos", new double[]{5.255833333333333E-4, 1.0895833333333333E-4});
    model.geom("geom1").feature("EllipseIF238")
         .set("semiaxes", new double[]{6.740582021372858E-5, 6.560134187515787E-5});
    model.geom("geom1").feature("EllipseIF238")
         .set("rot", 15.255083030037738);
    model.geom("geom1").feature("EllipseIF238").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF239", "Ellipse");
    model.geom("geom1").feature("EllipseIF239")
         .set("pos", new double[]{5.446894977168949E-4, 1.2227853881278537E-4});
    model.geom("geom1").feature("EllipseIF239")
         .set("semiaxes", new double[]{6.958040805769424E-5, 6.50207070547873E-5});
    model.geom("geom1").feature("EllipseIF239")
         .set("rot", 63.434800484764544);
    model.geom("geom1").feature("EllipseIF239").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF240", "Ellipse");
    model.geom("geom1").feature("EllipseIF240")
         .set("pos", new double[]{5.706245210727968E-4, 1.5344444444444444E-4});
    model.geom("geom1").feature("EllipseIF240")
         .set("semiaxes", new double[]{7.47373749379874E-5, 6.467376124939682E-5});
    model.geom("geom1").feature("EllipseIF240").set("rot", 86.98700908235035);
    model.geom("geom1").feature("EllipseIF240").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF241", "Ellipse");
    model.geom("geom1").feature("EllipseIF241")
         .set("pos", new double[]{5.727695473251028E-4, 2.755843621399177E-4});
    model.geom("geom1").feature("EllipseIF241")
         .set("semiaxes", new double[]{6.753023856823338E-5, 6.67217854624002E-5});
    model.geom("geom1").feature("EllipseIF241").set("rot", -85.6010944724094);
    model.geom("geom1").feature("EllipseIF241").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF242", "Ellipse");
    model.geom("geom1").feature("EllipseIF242")
         .set("pos", new double[]{5.902761904761904E-4, 5.478761904761904E-4});
    model.geom("geom1").feature("EllipseIF242")
         .set("semiaxes", new double[]{7.060093510027215E-5, 6.556076808846709E-5});
    model.geom("geom1").feature("EllipseIF242")
         .set("rot", 58.392361207010104);
    model.geom("geom1").feature("EllipseIF242").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF243", "Ellipse");
    model.geom("geom1").feature("EllipseIF243")
         .set("pos", new double[]{6.05247619047619E-4, 7.353999999999999E-4});
    model.geom("geom1").feature("EllipseIF243")
         .set("semiaxes", new double[]{6.67030600767678E-5, 6.562061541443285E-5});
    model.geom("geom1").feature("EllipseIF243").set("rot", 36.86981142818665);
    model.geom("geom1").feature("EllipseIF243").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF244", "Ellipse");
    model.geom("geom1").feature("EllipseIF244")
         .set("pos", new double[]{6.553722943722943E-4, 2.5279220779220776E-4});
    model.geom("geom1").feature("EllipseIF244")
         .set("semiaxes", new double[]{7.188664262694133E-5, 6.460536528814291E-5});
    model.geom("geom1").feature("EllipseIF244")
         .set("rot", -42.51034767031613);
    model.geom("geom1").feature("EllipseIF244").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF245", "Ellipse");
    model.geom("geom1").feature("EllipseIF245")
         .set("pos", new double[]{6.557417840375586E-4, 2.9756338028169013E-4});
    model.geom("geom1").feature("EllipseIF245")
         .set("semiaxes", new double[]{6.642585619517474E-5, 6.618947948425699E-5});
    model.geom("geom1").feature("EllipseIF245").set("rot", 5.194416760928864);
    model.geom("geom1").feature("EllipseIF245").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF246", "Ellipse");
    model.geom("geom1").feature("EllipseIF246")
         .set("pos", new double[]{6.768156028368794E-4, 5.391843971631206E-4});
    model.geom("geom1").feature("EllipseIF246")
         .set("semiaxes", new double[]{7.041435111257454E-5, 6.499553920466053E-5});
    model.geom("geom1").feature("EllipseIF246")
         .set("rot", -11.309906026540151);
    model.geom("geom1").feature("EllipseIF246").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF247", "Ellipse");
    model.geom("geom1").feature("EllipseIF247")
         .set("pos", new double[]{6.865342465753424E-4, 5.602876712328766E-4});
    model.geom("geom1").feature("EllipseIF247")
         .set("semiaxes", new double[]{6.729045990776208E-5, 6.549568315847664E-5});
    model.geom("geom1").feature("EllipseIF247").set("rot", 5.194416760928864);
    model.geom("geom1").feature("EllipseIF247").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF248", "Ellipse");
    model.geom("geom1").feature("EllipseIF248")
         .set("pos", new double[]{7.063974358974358E-4, 4.452435897435897E-4});
    model.geom("geom1").feature("EllipseIF248")
         .set("semiaxes", new double[]{7.376764573496585E-5, 6.467204316941225E-5});
    model.geom("geom1").feature("EllipseIF248").set("rot", 75.2562611816544);
    model.geom("geom1").feature("EllipseIF248").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF249", "Ellipse");
    model.geom("geom1").feature("EllipseIF249")
         .set("pos", new double[]{7.394600938967136E-4, 4.714788732394366E-4});
    model.geom("geom1").feature("EllipseIF249")
         .set("semiaxes", new double[]{6.695026995003257E-5, 6.607050160257936E-5});
    model.geom("geom1").feature("EllipseIF249")
         .set("rot", -63.434800484764544);
    model.geom("geom1").feature("EllipseIF249").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF250", "Ellipse");
    model.geom("geom1").feature("EllipseIF250")
         .set("pos", new double[]{7.86353846153846E-4, 6.724461538461537E-4});
    model.geom("geom1").feature("EllipseIF250")
         .set("semiaxes", new double[]{6.713333211913628E-5, 6.537991945687424E-5});
    model.geom("geom1").feature("EllipseIF250").set("rot", 44.99989477067122);
    model.geom("geom1").feature("EllipseIF250").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF251", "Ellipse");
    model.geom("geom1").feature("EllipseIF251")
         .set("pos", new double[]{7.985624999999999E-4, 8.062499999999999E-4});
    model.geom("geom1").feature("EllipseIF251")
         .set("semiaxes", new double[]{6.742383376003937E-5, 6.482886629433334E-5});
    model.geom("geom1").feature("EllipseIF251").set("rot", 37.87489508311804);
    model.geom("geom1").feature("EllipseIF251").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF252", "Ellipse");
    model.geom("geom1").feature("EllipseIF252")
         .set("pos", new double[]{8.048461538461537E-4, 1.654273504273504E-4});
    model.geom("geom1").feature("EllipseIF252")
         .set("semiaxes", new double[]{6.976262647541485E-5, 6.474253354085785E-5});
    model.geom("geom1").feature("EllipseIF252").set("rot", 82.4051639322893);
    model.geom("geom1").feature("EllipseIF252").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF253", "Ellipse");
    model.geom("geom1").feature("EllipseIF253")
         .set("pos", new double[]{8.189374999999999E-4, 5.244999999999999E-4});
    model.geom("geom1").feature("EllipseIF253")
         .set("semiaxes", new double[]{6.699596718384365E-5, 6.544889800539953E-5});
    model.geom("geom1").feature("EllipseIF253")
         .set("rot", -5.194416760928864);
    model.geom("geom1").feature("EllipseIF253").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF254", "Ellipse");
    model.geom("geom1").feature("EllipseIF254")
         .set("pos", new double[]{8.214235294117647E-4, 1.2487450980392157E-4});
    model.geom("geom1").feature("EllipseIF254")
         .set("semiaxes", new double[]{6.933885377841841E-5, 6.593542478757945E-5});
    model.geom("geom1").feature("EllipseIF254").set("rot", 85.91418231529447);
    model.geom("geom1").feature("EllipseIF254").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF255", "Ellipse");
    model.geom("geom1").feature("EllipseIF255")
         .set("pos", new double[]{8.362912912912912E-4, 2.2346246246246243E-4});
    model.geom("geom1").feature("EllipseIF255")
         .set("semiaxes", new double[]{6.920174372086625E-5, 6.76696931892575E-5});
    model.geom("geom1").feature("EllipseIF255")
         .set("rot", 50.194311531600086);
    model.geom("geom1").feature("EllipseIF255").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF256", "Ellipse");
    model.geom("geom1").feature("EllipseIF256")
         .set("pos", new double[]{8.469499999999999E-4, 4.940166666666666E-4});
    model.geom("geom1").feature("EllipseIF256")
         .set("semiaxes", new double[]{6.744081942191633E-5, 6.652672631441236E-5});
    model.geom("geom1").feature("EllipseIF256")
         .set("rot", -4.398695068933043);
    model.geom("geom1").feature("EllipseIF256").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF257", "Ellipse");
    model.geom("geom1").feature("EllipseIF257")
         .set("pos", new double[]{8.595208333333332E-4, 3.6020833333333326E-4});
    model.geom("geom1").feature("EllipseIF257")
         .set("semiaxes", new double[]{6.76229563316459E-5, 6.456177103796865E-5});
    model.geom("geom1").feature("EllipseIF257").set("rot", 70.01672974852882);
    model.geom("geom1").feature("EllipseIF257").set("createselection", "on");
    model.geom("geom1").feature().create("EllipseIF258", "Ellipse");
    model.geom("geom1").feature("EllipseIF258")
         .set("pos", new double[]{8.793966244725738E-4, 8.639535864978902E-4});
    model.geom("geom1").feature("EllipseIF258")
         .set("semiaxes", new double[]{6.716495680746875E-5, 6.588968950920745E-5});
    model.geom("geom1").feature("EllipseIF258").set("rot", 44.99989477067122);
    model.geom("geom1").feature("EllipseIF258").set("createselection", "on");
    model.geom("geom1").runAll();
    model.geom("geom1").feature().create("UnionLargeEllipse2", "Union");
    model.geom("geom1").feature("UnionLargeEllipse2").selection("input")
         .set(new String[]{"EllipseIF21", "EllipseIF22", "EllipseIF23", "EllipseIF24", "EllipseIF25", "EllipseIF26", "EllipseIF27", "EllipseIF28", "EllipseIF29", "EllipseIF210", "EllipseIF211", "EllipseIF212", "EllipseIF213", "EllipseIF214", "EllipseIF215", "EllipseIF216", "EllipseIF217", "EllipseIF218", "EllipseIF219", "EllipseIF220", "EllipseIF221", "EllipseIF222", "EllipseIF223", "EllipseIF224", "EllipseIF225", "EllipseIF226", "EllipseIF227", "EllipseIF228", "EllipseIF229", "EllipseIF230", "EllipseIF231", "EllipseIF232", "EllipseIF233", "EllipseIF234", "EllipseIF235", "EllipseIF236", "EllipseIF237", "EllipseIF238", "EllipseIF239", "EllipseIF240", "EllipseIF241", "EllipseIF242", "EllipseIF243", "EllipseIF244", "EllipseIF245", "EllipseIF246", "EllipseIF247", "EllipseIF248", "EllipseIF249", "EllipseIF250", "EllipseIF251", "EllipseIF252", "EllipseIF253", "EllipseIF254", "EllipseIF255", "EllipseIF256", "EllipseIF257", "EllipseIF258"});
    model.geom("geom1").feature("UnionLargeEllipse2")
         .set("createselection", "on");
    model.geom("geom1").feature("UnionLargeEllipse2").set("intbnd", "off");
    model.geom("geom1").runAll();
    model.geom("geom1").feature().create("DiffInterface2", "Difference");
    model.geom("geom1").feature("DiffInterface2").selection("input")
         .set(new String[]{"UnionLargeEllipse2"});
    model.geom("geom1").feature("DiffInterface2").selection("input2")
         .set(new String[]{"UnionLargeEllipse1"});
    model.geom("geom1").feature("DiffInterface2").set("keep", "on");
    model.geom("geom1").feature("DiffInterface2")
         .set("createselection", "on");
    model.geom("geom1").feature("DiffInterface2").set("intbnd", "off");
    model.geom("geom1").runAll();
    model.geom("geom1").feature().create("RectBlock", "Rectangle");
    model.geom("geom1").feature("RectBlock")
         .set("size", new double[]{9.833333333333332E-4, 9.833333333333332E-4});
    model.geom("geom1").feature("RectBlock").set("createselection", "on");
    model.geom("geom1").run("RectBlock");
    model.geom("geom1").feature().create("DiffMatrix", "Difference");
    model.geom("geom1").feature("DiffMatrix").selection("input")
         .set(new String[]{"RectBlock"});
    model.geom("geom1").feature("DiffMatrix").selection("input2")
         .set(new String[]{"UnionLargeEllipse2"});
    model.geom("geom1").feature("DiffMatrix").set("keep", "on");
    model.geom("geom1").feature("DiffMatrix").set("createselection", "on");
    model.geom("geom1").runAll();
    model.geom("geom1").feature().create("UnionDomODE", "Union");
    model.geom("geom1").feature("UnionDomODE").selection("input")
         .set(new String[]{"DiffInterface1", "DiffInterface2", "DiffMatrix"});
    model.geom("geom1").feature("UnionDomODE").set("keep", "on");
    model.geom("geom1").feature("UnionDomODE").set("createselection", "on");
    model.geom("geom1").runAll();
    model.geom("geom1").run();
    model.geom("geom1").run();
    model.geom("geom1").run();
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
         .set("relpermittivity", "2.4-j*0.001");
    model.material("mat4").propertyGroup("def")
         .set("electricconductivity", 1.0E-11);
    model.material("mat5").propertyGroup("def")
         .set("relpermittivity", "epint-j*eppint");
    model.material("mat5").propertyGroup("def")
         .set("electricconductivity", 1.0E-15);

    model.physics().create("ec", "ConductiveMedia", "geom1");
    model.physics("ec").feature("init1").set("V", 1, 1.0E-5);
    model.physics("ec").feature().create("pc1", "PeriodicCondition", 1);
    model.physics("ec").feature("pc1").selection().set(new int[]{1, 4});
    model.physics("ec").feature().create("gnd1", "Ground", 1);
    model.physics("ec").feature("gnd1").selection().set(new int[]{3});
    model.physics("ec").feature().create("term1", "Terminal", 1);
    model.physics("ec").feature("term1").selection().set(new int[]{2});
    model.physics("ec").feature("term1").set("TerminalType", 1, "Voltage");
    model.physics("ec").feature("term1").set("V0", 1, 0.0015);
    model.physics().create("dode1", "DomainODE", "geom1", new String[]{"u"});
    model.physics("dode1").selection().named("geom1_UnionDomODE_dom");
    model.physics("dode1").feature("dode1").set("f", 1, "MySwitch");
    model.physics().create("dode2", "DomainODE", "geom1", new String[]{"u2"});
    model.physics("dode2").selection().named("geom1_UnionDomODE_dom");
    model.physics("dode2").feature("dode1").set("f", 1, "MyBoola");
    model.physics().create("dode3", "DomainODE", "geom1", new String[]{"u3"});
    model.physics("dode3").selection().named("geom1_UnionDomODE_dom");
    model.physics("dode3").feature("dode1")
         .set("f", 1, "sqrt(ec.normE*ec.normE)/1[V*m]");

    model.mesh().create("mesh1", "geom1");
    model.mesh("mesh1").autoMeshSize(5);
    model.mesh("mesh1").run();

    model.variable("var1").set("TS1", "1");
    model.variable("var1").set("DS1", "1");
    model.variable("var1").set("TS2", "1");
    model.variable("var1").set("DS2", "1");
    model.variable("var1").set("const", "0");

    model.study().create("std1");
    model.study("std1").feature().create("freq", "Frequency");
    model.study("std1").feature("freq").set("geomselection", "geom1");
    model.study("std1").feature("freq").set("physselection", "ec");
    model.study("std1").feature("freq")
         .set("plist", new double[]{0.0010, 0.001584893192461114, 0.0025118864315095794, 0.003981071705534973, 0.00630957344480193, 0.01, 0.01584893192461114, 0.025118864315095808, 0.039810717055349734, 0.06309573444801933, 0.1, 0.15848931924611143, 0.25118864315095824, 0.3981071705534973, 0.6309573444801937, 1, 1.5848931924611143, 2.5118864315095824, 3.981071705534973, 6.309573444801936, 10, 15.848931924611142, 25.11886431509582, 39.81071705534969, 63.0957344480193, 100, 158.48931924611125, 251.18864315095797, 398.1071705534969, 630.957344480193, 1000, 1584.8931924611124, 2511.88643150958, 3981.071705534969, 6309.57344480193, 10000, 15848.93192461114, 25118.864315095823, 39810.71705534969, 63095.7344480193, 100000, 158489.3192461114, 251188.6431509582, 398107.1705534969, 630957.344480193, 1000000});

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
         .set("plist", new double[]{0.0010, 0.001584893192461114, 0.0025118864315095794, 0.003981071705534973, 0.00630957344480193, 0.01, 0.01584893192461114, 0.025118864315095808, 0.039810717055349734, 0.06309573444801933, 0.1, 0.15848931924611143, 0.25118864315095824, 0.3981071705534973, 0.6309573444801937, 1, 1.5848931924611143, 2.5118864315095824, 3.981071705534973, 6.309573444801936, 10, 15.848931924611142, 25.11886431509582, 39.81071705534969, 63.0957344480193, 100, 158.48931924611125, 251.18864315095797, 398.1071705534969, 630.957344480193, 1000, 1584.8931924611124, 2511.88643150958, 3981.071705534969, 6309.57344480193, 10000, 15848.93192461114, 25118.864315095823, 39810.71705534969, 63095.7344480193, 100000, 158489.3192461114, 251188.6431509582, 398107.1705534969, 630957.344480193, 1000000});
    model.sol("sol1").feature("s1").feature("p1").set("plot", "off");
    model.sol("sol1").feature("s1").feature("p1").set("probesel", "all");
    model.sol("sol1").feature("s1").feature("p1").set("probes", null);
    model.sol("sol1").feature("s1").feature("p1").set("control", "freq");
    model.sol("sol1").feature("s1").set("control", "freq");
    model.sol("sol1").feature("s1").feature().create("fc1", "FullyCoupled");
    model.sol("sol1").feature("s1").feature().remove("fcDef");
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result().create("pg1", 2);
    model.result("pg1").set("data", "dset1");
    model.result("pg1").feature().create("surf1", "Surface");
    model.result("pg1").feature("surf1").set("expr", "ec.normE");
    model.result("pg1").feature("surf1").set("descr", "Electric field norm");
    model.result("pg1").name("Electric Field Norm (ec)");
    model.result("pg1").run();
    model.result().numerical().create("av1", "AvLine");
    model.result().numerical("av1").selection().set(new int[]{3});
    model.result().table().create("tbl1", "Table");
    model.result().table("tbl1")
         .comments("Line Average 1, Epsilon Double Prime");
    model.result().numerical("av1").set("table", "tbl1");
    model.result().numerical("av1")
         .set("expr", "real(ec.Jy/0.0015[V])*0.000983[mm]/ec.freq/2/3.14/8.85e-12[F/m]");
    model.result().numerical("av1").set("descr", "Epsilon Double Prime");
    model.result().numerical("av1").setResult();
    model.result().create("pg2", 1);
    model.result("pg2").feature().create("tblp1", "Table");
    model.result("pg2").feature("tblp1").set("table", "tbl1");
    model.result("pg2").run();
    model.result().export().create("plot1", "pg2", "tblp1", "Plot");
    model.result().export("plot1").set("header", "off");
    model.result().export("plot1")
         .set("filename", "./HZ_2D_comsolbuild_AC_binary_06-Aug-2015_IP10+50_run_1_CompPermImag.csv");
    model.result().export("plot1").run();
    model.result().numerical().create("av2", "AvLine");
    model.result().numerical("av2").selection().set(new int[]{3});
    model.result().table().create("tbl2", "Table");
    model.result().table("tbl2").comments("Line Average 2, Epsilon Prime");
    model.result().numerical("av2").set("table", "tbl2");
    model.result().numerical("av2")
         .set("expr", "imag(ec.Jy/0.0015[V])*0.000983[mm]/ec.freq/2/3.14/8.85e-12[F/m]");
    model.result().numerical("av2").set("descr", "Epsilon Prime");
    model.result().numerical("av2").setResult();
    model.result().create("pg3", 1);
    model.result("pg3").feature().create("tblp2", "Table");
    model.result("pg3").feature("tblp2").set("table", "tbl2");
    model.result("pg3").run();
    model.result().export().create("plot2", "pg3", "tblp2", "Plot");
    model.result().export("plot2").set("header", "off");
    model.result().export("plot2")
         .set("filename", "./HZ_2D_comsolbuild_AC_binary_06-Aug-2015_IP10+50_run_1_CompPermReal.csv");
    model.result().export("plot2").run();

    model.name("HZ_2D_comsolbuild_AC_binary_06-Aug-2015_IP10+50_run_1.mph");

    return model;
  }

}
