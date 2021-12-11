package br.com.dineduc.backend.app.mapper

import br.com.dineduc.backend.app.dto.BannerDto
import br.com.dineduc.backend.app.dto.LessonDto
import br.com.dineduc.backend.app.dto.ModuleDto
import br.com.dineduc.backend.app.dto.TrailDto
import br.com.dineduc.backend.service.facade.valueObject.BannerVO
import br.com.dineduc.backend.service.facade.valueObject.LessonVO
import br.com.dineduc.backend.service.facade.valueObject.ModuleVO
import br.com.dineduc.backend.service.facade.valueObject.TrailVO


class ModuleMapper {
    companion object {

        fun moduleDtoFromModuleVO(moduleVO: ModuleVO): ModuleDto {
            val lessons = moduleVO.lessons?.map { lessonDtoFromLessonVO(it) }
            return  ModuleDto(moduleVO.id, moduleVO.title, moduleVO.description, moduleVO.published_at, trailDtoFromTrailVO(moduleVO.trail), bannerDtoFromBannerVO(moduleVO.banner), lessons?.toList())
        }

        fun lessonDtoFromLessonVO(lessonVO: LessonVO): LessonDto {
            return LessonDto(lessonVO.id, lessonVO.title)
        }

        fun bannerDtoFromBannerVO(bannerVO: BannerVO?): BannerDto? {
            bannerVO?.let {
                return BannerDto(it.alternativeText, it.caption, it.url, it.previewUrl)
            }
            return null
        }

        fun trailDtoFromTrailVO(trailVO: TrailVO?): TrailDto? {
            trailVO?.let {
                return TrailDto(it.id, it.title, it.description, it.published_at)
            }
            return null
        }
    }
}