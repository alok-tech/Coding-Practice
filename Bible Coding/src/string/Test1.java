package string;

import com.sinch.xms.ApiConnection;
import com.sinch.xms.api.MtBatchTextSmsResult;

public class Test1 {
      public static void sendSms() {
          try (ApiConnection conn = ApiConnection.builder()
          .servicePlanId("{spid}").token("{token}").start()) {
              MtBatchTextSmsResult batch = conn.createBatch(
              ClxApi.batchTextSms()
              .sender("12345")
              .addRecipient("46123123123")
              .body("Hello, world!")
              .build());

              System.out.println("Successfully sent batch " + batch.id());
          } catch (Exception e) {
              System.out.println("Batch send failed: " + e.getMessage());
          }
      }
}
