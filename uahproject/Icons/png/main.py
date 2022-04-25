from w1thermsensor import W1ThermSensor  # Importamos el paquete W1ThermSensor
import time  # Importamos el paquete time
import pymysql
import fnmatch
import os
sensor = W1ThermSensor()  # Creamos el objeto sensor

# cursor.execute("show tables")
# records = cursor.fetchall()


def insertDB(IDs, temp, date, hour):
    try:
        con = pymysql.connect(
            host='192.168.1.81',
            port=3306,
            user='temperature',
            password='Us5RDQoj',
            db='temperature',
            charset='latin1'
        )
        cursor = con.cursor()
        timestamp = int(time.time()/100)*100
        temp = int(round(temp))
        if temp is not None and IDs is not None:
            print(f"La temperatura es {temp} y el id es {IDs}, {date}, \
            hour es {hour}")
            try:
                cursor.execute("insert into temp_log(sensor_id, date, time, timestamp, value, value_int) value('%s','%s','%s','%s','%s','%s')" % (
                    IDs, date, hour, timestamp, temp, int(temp)))
                con.commit()
            except pymysql.Error as err:
                print("Something went wrong: {}".format(err))
                con.close()
                return None
        else:
            print('Failed to get reading. Try again!')
        con.close()
    except pymysql.Error as err:
        print("Something went wrong: {}".format(err))
        return None


def main():
    while True:
        for filename in os.listdir("/sys/bus/w1/devices"):
            if fnmatch.fnmatch(filename, '28-*'):
                with open("/sys/bus/w1/devices/" + filename + "/w1_slave") as fileobj:
                    lines = fileobj.readlines()
                    if not lines:
                        print("The list is empty try to read again")
                    else:
                        if lines[0].find("YES"):
                            pok = lines[1].find('=')
                            temperature = float(lines[1][pok+1:pok+6])/1000
                            sensor_1 = filename
                            date = time.strftime("%Y-%m-%d")
                            hour = time.strftime("%H:%M")
                            insertDB(sensor_1, temperature, date, hour)
        time.sleep(60)  # Esperamos un segundo antes de terminar el ciclo


main()
