### USER resource

curl get http://localhost:9000/users/test


### BIRTH Resource - This will return an AWARD

curl --header "Content-Type: application/json" \
	--request POST \
	--data '{"userName":"test","dateTime":"2021-02-13T00:00:00"}' \
	http://localhost:9000/events/birth


### MOOD Resource - This will return an AWARD, if qaulify

curl --header "Content-Type: application/json" \
	--request POST \
	--data '{"userName":"test", "moodType": "HAPPY", "dateTime":"2021-02-01T00:00:00"}' \
	http://localhost:9000/events/mood

curl --header "Content-Type: application/json" \
	--request POST \
	--data '{"userName":"test", "moodType": "HAPPY", "dateTime":"2021-02-02T00:00:00"}' \
	http://localhost:9000/events/mood

	curl --header "Content-Type: application/json" \
	--request POST \
	--data '{"userName":"test", "moodType": "HAPPY", "dateTime":"2021-02-03T00:00:00"}' \
	http://localhost:9000/events/mood

curl --header "Content-Type: application/json" \
	--request POST \
	--data '{"userName":"test", "moodType": "HAPPY", "dateTime":"2021-02-04T00:00:00"}' \
	http://localhost:9000/events/mood

curl --header "Content-Type: application/json" \
	--request POST \
	--data '{"userName":"test", "moodType": "HAPPY", "dateTime":"2021-02-05T00:00:00"}' \
	http://localhost:9000/events/mood


### AWARD Resource

curl get http://localhost:9000/awards/test