package taskify

//import grails.rest.Resource
import groovy.transform.CompileStatic
import grails.compiler.GrailsCompileStatic
import groovy.transform.EqualsAndHashCode
//import gorm.restapi.RestApiController
import gorm.restapi.RestApi
import java.time.LocalDate

@GrailsCompileStatic
@EqualsAndHashCode(includes = 'num,name')
@RestApi(description = "This is a project ")
class Project {

    static constraints = {
        num        description: "The project short code or unique identifier", example:"client-123",
                    nullable: false, maxSize:10
        name        description: "The project name", example:"Cool Project",
                    nullable: false, maxSize:50
        inactive    description: "is project inactivated", nullable: false

        billable    description: "does this get invoiced? If its set to true,\
                                  tasks can be overriden to be false " ,
                    nullable: false

        startDate	description: "Start date of project.", example:"2017-01-01"
        endDate	    description: "End date of project.", example:"2017-12-30"
        activateDate description: "Date time project is activated", example:"2017-12-30"

    }

    static mapping = {
        inactive defaultValue: "0"
        billable defaultValue: "0"
    }

    String num
    String name
    Boolean inactive = false
    Boolean billable = true
    LocalDate startDate
    LocalDate endDate
    Date activateDate
}
