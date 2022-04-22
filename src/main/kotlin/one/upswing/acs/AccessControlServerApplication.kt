package one.upswing.acs

import com.fasterxml.jackson.databind.DeserializationFeature
import one.upswing.acs.models.Sample2
import one.upswing.acs.models.ThreeRIIndicator
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid


@SpringBootApplication
class AccessControlServerApplication {
	@Bean
	fun enableFailOnNumbersForEnums(): Jackson2ObjectMapperBuilderCustomizer? {
		return Jackson2ObjectMapperBuilderCustomizer { jacksonObjectMapperBuilder: Jackson2ObjectMapperBuilder ->
			jacksonObjectMapperBuilder.featuresToEnable(
				DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS
			)
		}
	}
}

fun main(args: Array<String>) {
	runApplication<AccessControlServerApplication>(*args)
}

data class Message(val id: String?, val text: String)

@RestController
class MessageResource {
	@GetMapping
	fun index(): List<Message> = listOf(
		Message("1", "Hello!"),
		Message("2", "Bonjour!"),
		Message("3", "Privet!"),
	)

	@PostMapping("/sample")
	fun sample(@Valid @RequestBody payload: Sample2): ThreeRIIndicator {
		println(payload)
		return ThreeRIIndicator.ADD_CARD
	}

//	@PostMapping("/sample")
//	fun sample(@RequestBody payload: Sample2): Sample2 {
//		return payload
//	}
}