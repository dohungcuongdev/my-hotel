C:

cd C:\Program Files\MongoDB\Server\3.4\bin

mongoexport -d HotelBookingReservationsSystem -c my-hotel-reservation -o D:\thesis-in-process\my-hotel\query\json\my-hotel-reservation.json
mongoexport -d HotelBookingReservationsSystem -c my-hotel-room -o D:\thesis-in-process\my-hotel\query\json\my-hotel-room.json
mongoexport -d HotelBookingReservationsSystem -c my-hotel-addition-payment -o D:\thesis-in-process\my-hotel\query\json\my-hotel-addition-payment.json