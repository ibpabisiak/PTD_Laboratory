package ptd.main;

import ptd.gui.CLineChart;
import org.jfree.data.xy.XYSeriesCollection;
import ptd.core.ILabFactory;

/**
 *
 * @author Bartlomiej Pabisiak <bpabisiak@wi.zut.edu.pl>
 */
public class CAppStart
{
    private static final CLineChart LINE_CHART = CLineChart.getInstance(); 
    
    public static void main(String[] args) throws Exception
    {
        XYSeriesCollection oDataset = new XYSeriesCollection();
        ILabFactory oLaboratory = CLabFactory.getLab(4);

        if(null != oLaboratory)
        {
            oDataset.addSeries(oLaboratory.getTask1()
                    .execute());            
//            oDataset.addSeries(oLaboratory.getTask2(18, 15)
//                    .execute());
//            oDataset.addSeries(oLaboratory.getTask2(12, 17)
//                    .execute());
//            oDataset.addSeries(oLaboratory.getTask2(13, 13)
//                    .execute());
//            oDataset.addSeries(oLaboratory.getTask3(5)
//                    .execute());
//            oDataset.addSeries(oLaboratory.getTask3(10)
//                    .execute());
//            oDataset.addSeries(oLaboratory.getTask3(15)
//                    .execute());
        }

        LINE_CHART.plot(oDataset, "Lab3");
    }
}
