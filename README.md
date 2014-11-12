#Training: Threading

Este proyecto consiste de un `Activity` que tiene 2 botones. 
- El primer botón hace un sleep en el main thread, bloqueandolo por 10 segundos. 
- El segundo botón, descarga un item de la API de Meli y muestra su nombre, precio y cantidad. 

Pero el proyecto tiene algunos problemas...
- Primero tocar el botón "Block UI Thread" y luego tratar de tocarlo nuevamente o tocar la pantalla en cualquier lado. Como el UI Thread esta bloqueado, no puede responder a sus acciones en la pantalla y les ofrece esperar o matar la app porque no esta respondiendo. 
- Luego, tocar el botón "Download Item". Porque crashea? Miren la excepción que muestra el LogCat.

Vamos a arreglar el problema del crash del segundo botón:
- Pasar el código que se ejecuta cuando se toca el botón a una [AsyncTask](http://developer.android.com/reference/android/os/AsyncTask.html). La misma debería descargar el item y en el método 'OnPostExecute' debería actualizar las vistas.
- Una vez que tenemos el código corriendo en una AsyncTask, decidimos que no es una gran idea y preferimos usar un [Handler](http://developer.android.com/reference/android/os/Handler.html). Para hacerlo, debemos crear un Thread que ejecute la descarga del item y una vez que finaliza, notifique al [Handler](http://developer.android.com/reference/android/os/Handler.html) para que actualice las vistas. Para que esto funcione, que Looper se debería asociar al Handler?
