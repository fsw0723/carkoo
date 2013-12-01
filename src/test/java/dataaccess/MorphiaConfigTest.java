//package dataaccess;
//
//import com.google.code.morphia.Datastore;
//import com.google.code.morphia.Morphia;
//import com.mongodb.Mongo;
//import com.mongodb.MongoException;
//import junit.framework.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.test.util.ReflectionTestUtils;
//
//import java.net.UnknownHostException;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
//public class MorphiaConfigTest {
//
//        private MorphiaConfig morphiaConfiguration;
//
//        @Before
//        public void setUp() throws Exception {
//
//            morphiaConfiguration = new MorphiaConfig() {
//                @Override
//                public Mongo mongo() throws UnknownHostException, MongoException {
//                    return mock(Mongo.class);
//                }
//
//                @Override
//                public Morphia morphia() {
//                    Morphia morphia = mock(Morphia.class);
//                    Datastore datastore = mock(Datastore.class);
//                    when(morphia.createDatastore(any(Mongo.class),any(String.class))).thenReturn(datastore);
//                    when(morphia.createDatastore(any(Mongo.class),any(String.class),any(String.class),any((new char[0]).getClass()))).thenReturn(datastore);
//                    return morphia;
//                }
//            };
//        }
//
//        @Test
//        public void shouldHaveNoErrorsWhenCreatingMorphiaInstance() throws Exception {
//            Morphia morphia = morphiaConfiguration.morphia();
//            assertNotNull(morphia);
//
//        }
//        @Test
//        public void shouldCreateReplicaSetConfiguration() throws UnknownHostException {
//            ReflectionTestUtils.setField(morphiaConfiguration, "dbHost", "127.0.0.1, 127.0.0.1");
//            assertEquals(morphiaConfiguration.replicaSets().size(), 2);
//            assertEquals(morphiaConfiguration.replicaSets().get(0).getHost(), "127.0.0.1");
//            assertEquals(morphiaConfiguration.replicaSets().get(0).getPort(), ReflectionTestUtils.getField(morphiaConfiguration, "dbPort"));
//        }
//
//}
