<#if dependencyMap?size gt 0>
    <#list dependencyMap as e>
        <#assign artifact = e.getKey()/>
        <#assign licenses = e.getValue()/>
        <#lt>"${artifact.name}";"${artifact.groupId}";"${artifact.artifactId}";"${artifact.version}";"${printLicense(licenses)}";"${artifact.url!""}"
    </#list>
</#if>
<#function printLicense licenses>
    <#assign result = ""/>
    <#list licenses as license>
        <#if license != "Unknown license">
            <#assign result = result + license />
        </#if>
        <#if license_has_next>
            <#assign result = result + "|" />
        </#if>
    </#list>
    <#return result>
</#function>
