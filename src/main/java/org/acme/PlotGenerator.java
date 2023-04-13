package org.acme;

import io.quarkus.scheduler.Scheduled;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@ApplicationScoped
public class PlotGenerator {
    List<Plot> plots = new ArrayList<>();
    @Inject
    @Channel("plot-out")
    Emitter<Plot> sendToKafka;
    Integer i = 1;
    Random X = new Random();
    double randomValue = 10.0 + (50.0 - 10.0) * X.nextDouble();
    public static void wait(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

    @Scheduled(every = "5s")
    public void onStart() {
        if (i < 500){
            for(int j=1; j<21; j++){

                String plot2;

                //koordinatX
                double startX = -8.667918002363107;
                double endX = 6.096859818887948;
                double random1 = new Random().nextDouble();
                double resultX = startX + (random1 * (endX - startX));

                //koordinatY
                double startY = 94.79003906250001;
                double endY = 139.92187500000003;
                double random = new Random().nextDouble();
                double resultY = startY + (random * (endY - startY));

                Plot plot1 = new Plot(i,"Plot "+i,"Warna "+i,"Deskripsi "+i,resultX,resultY);
                plots.add(plot1);
                sendToKafka.send(plot1);

//                String array = "{\"id\":"+i+",\"nama\":\"Plot "+i+"\",\"warna\":\"Warna "+i+"\",\"deskripsi\":\"Des "+i+"\",\"koordinatX\":"+resultX+",\"koordinatY\":"+resultX+"}";
//                sendToKafka.send(array);

                i++;
            }
            wait(1000);

        } else  {
            i = 1;
        }
    }
}
